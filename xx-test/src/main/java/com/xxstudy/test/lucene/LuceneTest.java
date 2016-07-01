package com.xxstudy.test.lucene;

import com.chenlb.mmseg4j.analysis.MMSegAnalyzer;
import com.xxbase.test.BaseTest;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.cjk.CJKAnalyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.document.*;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.Token;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Attribute;
import org.apache.lucene.util.BytesRef;
import org.apache.lucene.util.Version;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.io.StringReader;
import java.util.Iterator;

/**
 * Created by admin on 16/06/11.
 */
public class LuceneTest extends BaseTest {


    @Test
    public void testBuildTxtFileIndexer() throws IOException, ParseException {
//        String indexFilePath = XXSystemUtils.getClasspath("index_file");

        Analyzer analyzer = new SimpleAnalyzer();

        // Store the index in memory:
        Directory directory = new RAMDirectory();
//        Directory directory = FSDirectory.open("/tmp/testindex");

        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_4_10_0, analyzer);
        IndexWriter writer = new IndexWriter(directory, config);

        Document document = new Document();

        String text = "This is the text to be indexed.";
        String path = "D:\\job\\qh-tms\\entity";
        document.add(new Field("filename", text, TextField.TYPE_STORED));
        document.add(new Field("path", path, TextField.TYPE_STORED));

        writer.addDocument(document);

        writer.close();


        DirectoryReader reader = DirectoryReader.open(directory);
        IndexSearcher searcher = new IndexSearcher(reader);
//        QueryParser parser = new QueryParser("filename", analyzer);
//        Query query = parser.parse("indexed");

        Query query = new TermQuery(new Term("filename", "text"));

        ScoreDoc[] hits = searcher.search(query, 1).scoreDocs;

        for (int i = 0, len = hits.length; i < len; i++) {
            Document doc = searcher.doc(hits[i].doc);
            logger.info(doc.get("filename"));
            logger.info(doc.get("path"));
        }
        reader.close();
        directory.close();
    }


    @Test
    public void testBuildTxtFileIndexer02() throws IOException {

        String[] idArr = {"1", "2", "3", "4", "5", "6"};
        String[] emailArr = {"abc@us.ibm.com", "ert@cn.ibm.com", "lucy@us.ibm.com",
                "rock@cn.ibm.com", "test@126.com", "deploy@163.com"};
        String[] contentArr = {
                "welcome to Lucene,I am abc",
                "This is ert,I am from China",
                "I'm Lucy,I am english",
                "I work in IBM",
                "I am a tester",
                "I like Lucene in action"
        };

        String[] nameArr = {"abc", "ert", "lucy", "rock", "test", "deploy"};

        Analyzer analyzer = new StandardAnalyzer();
        Directory directory = new RAMDirectory();

        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_4_10_0, analyzer);
        IndexWriter writer = new IndexWriter(directory, config);

        Document doc = null;
        for (int i = 0, len = idArr.length; i < len; i++) {
            doc = new Document();
            doc.add(new StringField("id", idArr[i], Field.Store.YES));
            doc.add(new StringField("email", emailArr[i], Field.Store.YES));
            doc.add(new Field("content", contentArr[i], TextField.TYPE_STORED));
            doc.add(new StringField("name", nameArr[i], Field.Store.YES));
            doc.add(new StringField("date", "2016010" + (i + 1) + "222222", Field.Store.YES));
            writer.addDocument(doc);
        }

        writer.close();

        //-----------------------------------------------

        DirectoryReader reader = DirectoryReader.open(directory);
        IndexSearcher searcher = new IndexSearcher(reader);

        searchByTerm(searcher, "id", "2", 10);
        line();

        searchByTerm(searcher, "content", "action", 10);
        line();

        searchByTermRange(searcher, "name", "abc", "rock", 3);
        line();

        searchByPrefix(searcher, "email", "deploy", 3);
        line();

        searchByWildcard(searcher, "name", "*c?", 10);
        line();

        searchByFuzzy(searcher, "name", "acc", 10);
        line();

        reader.close();
        directory.close();
    }



    @Test
    public void testTokenStream() throws IOException {
            Analyzer analyzer = new IKAnalyzer();

        String txt = "Lucene 是一个基于 Java 的全文信息检索工具包，它不是一个完整的搜索应用程序，而是为你的应用程序提供索引和搜索功能。Lucene 目前是 Apache Jakarta 家族中的一个开源项目。也是目前最为流行的基于 Java 开源全文检索工具包。";

        Directory directory = new RAMDirectory();

        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_4_10_0, analyzer);
        IndexWriter writer = new IndexWriter(directory, config);

        Document doc = new Document();

        doc.add(new Field("text", txt, TextField.TYPE_STORED));

        writer.addDocument(doc);

        TokenStream ts = analyzer.tokenStream("text", new StringReader(txt));
        ts.reset();
        CharTermAttribute term = ts.addAttribute(CharTermAttribute.class);

        while (ts.incrementToken()){
            logger.info("token : {}", term.toString());
        }


        writer.close();
    }


    /**
     * 使用 TermQuery 搜索
     *
     * @param searcher
     * @param field
     * @param name
     * @param num
     * @throws IOException
     */
    private void searchByTerm(IndexSearcher searcher, String field, String name, int num) throws IOException {
        Query query = new TermQuery(new Term(field, name));
        TopDocs td = searcher.search(query, num);

        print(searcher, td);
    }

    /**
     * 指定区间检索
     *
     * @param searcher
     * @param field
     * @param start
     * @param end
     * @param num
     * @throws IOException
     */
    private void searchByTermRange(IndexSearcher searcher, String field, String start, String end, int num) throws IOException {
        BytesRef lowerTerm = new BytesRef(start);
        BytesRef upperTerm = new BytesRef(end);

        Query query = new TermRangeQuery(field, lowerTerm, upperTerm, true, true);

        TopDocs td = searcher.search(query, num);

        print(searcher, td);
    }

    /**
     * 前缀检索
     *
     * @param searcher
     * @param field
     * @param value
     * @param num
     * @throws IOException
     */
    private void searchByPrefix(IndexSearcher searcher, String field, String value, int num) throws IOException {

        Query query = new PrefixQuery(new Term(field, value));

        TopDocs td = searcher.search(query, num);

        print(searcher, td);
    }

    /**
     * 通配符检索
     * 通配符分为两种，“*”和“？”，“*”表示任何字符，“？”表示任意一个字符。
     *
     * @param searcher
     * @param field
     * @param value
     * @param num
     * @throws IOException
     */
    private void searchByWildcard(IndexSearcher searcher, String field, String value, int num) throws IOException {
        Query query = new WildcardQuery(new Term(field, value));

        TopDocs td = searcher.search(query, num);

        print(searcher, td);
    }

    /**
     * 模糊匹配
     *
     * @param searcher
     * @param field
     * @param valule
     * @param num
     * @throws IOException
     */
    private void searchByFuzzy(IndexSearcher searcher, String field, String valule, int num) throws IOException {
        Query query = new FuzzyQuery(new Term(field, valule), 1, 1);//第一个参数是词条对象，第二个参数是 levenshtein 算法的最小相似度，第三个参数是指与多少个前缀字符匹配。

        TopDocs td = searcher.search(query, num);

        print(searcher, td);
    }


    private void print(IndexSearcher searcher, TopDocs td) throws IOException {
        logger.info("count : {}", td.totalHits);

        for (ScoreDoc sd : td.scoreDocs) {
            Document doc = searcher.doc(sd.doc);
            logger.info("id ： {}", doc.get("id"));
            logger.info("name ： {}", doc.get("name"));
            logger.info("email   ： {}", doc.get("email"));
            logger.info("date ： {}", doc.get("date"));
            logger.info("content ： {}", doc.get("content"));
        }
    }

}
