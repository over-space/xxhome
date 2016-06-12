<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel='stylesheet' type='text/css' href='http://fonts.useso.com/css?family=Open+Sans:300,400,600,700,400italic'>
    <link rel="stylesheet" type="text/css" href="${xxblog_path}/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${xxblog_path}/fonts/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="${xxblog_path}/css/style.css">

    <title>Accord - Gallery</title>
</head>

<body class="gallery-page">

<div class="main-body">
    <div class="container">
        <div class="row">

            <div class="main-page">
                <aside class="main-navigation">
                    <#include "xx-blog/base/menu.ftl"/>
                </aside> <!-- main-navigation -->

                <!-- content-main -->
                <div class="content-main gallery_main">

                    <div class="gallery-main-inner">

                        <div class="col-md-12 gallery_title_main">
                            <div class="gallery_title">
                                <h3>GALLERY</h3>
                                <h4>RESPONSIVE DESIGN</h4>
                            </div>
                            <br style="clear:both;"/>
                        </div>

                        <div id="content" class="gallery-images-container">
                            <div class="box-gutter"></div>
                            <div class="box-sizer"></div>
                            <div class="box">
                                <a href="${xxblog_path}/images/gallery-item-1-big.jpg"><img alt="Agra picture"
                                                                                            src="${xxblog_path}/images/gallery-item-1.jpg"></a>
                            </div>
                            <div class="box">
                                <a href="${xxblog_path}/images/gallery-item-4-big.jpg"><img alt="Agra picture"
                                                                                            src="${xxblog_path}/images/gallery-item-4.jpg"></a>
                            </div>
                            <div class="box">
                                <a href="${xxblog_path}/images/gallery-item-6-big.jpg"><img alt="Agra picture"
                                                                                            src="${xxblog_path}/images/gallery-item-6.jpg"></a>
                            </div>
                            <div class="box">
                                <a href="${xxblog_path}/images/gallery-item-2-big.jpg"><img alt="Agra picture"
                                                                                            src="${xxblog_path}/images/gallery-item-2.jpg"></a>
                            </div>
                            <div class="box">
                                <a href="${xxblog_path}/images/gallery-item-5-big.jpg"><img alt="Agra picture"
                                                                                            src="${xxblog_path}/images/gallery-item-5.jpg"></a>
                            </div>
                            <div class="box">
                                <a href="${xxblog_path}/images/gallery-item-7-big.jpg"><img alt="Agra picture"
                                                                                            src="${xxblog_path}/images/gallery-item-7.jpg"></a>
                            </div>
                            <div class="box">
                                <a href="${xxblog_path}/images/gallery-item-8-big.jpg"><img alt="Agra picture"
                                                                                            src="${xxblog_path}/images/gallery-item-8.jpg"></a>
                            </div>
                            <div class="box">
                                <a href="${xxblog_path}/images/gallery-item-3-big.jpg"><img alt="Agra picture"
                                                                                            src="${xxblog_path}/images/gallery-item-3.jpg"></a>
                            </div>
                        </div>

                        <div class="row text-center view_more_main">
                            <a href="#" class="btn view_more">view more</a>
                        </div>

                    </div>

                </div>
            </div> <!-- .main-page -->
        </div> <!-- .row -->
        <footer class="row">
        <#include "xx-blog/base/footer.ftl"/>
        </footer>  <!-- .row -->

    </div> <!-- .container -->
</div>  <!-- .main-body -->


<script src="${xxbase_path}/js/jquery-1.11.3.min.js"></script>
<script src="${xxblog_path}/js/bootstrap.min.js"></script>
<script src="${xxblog_path}/js/imagesloaded.3.1.8.min.js"></script>
<script src="${xxblog_path}/js/jquery.masonry.3.2.1.min.js"></script> <!-- http://masonry.desandro.com/ -->
<script src="${xxblog_path}/js/jquery.magnific-popup.min.js"></script>
<!-- http://dimsemenov.com/plugins/magnific-popup/ -->

<script>
    function init_masonry() {
        var $container = $('#content');

        $container.imagesLoaded(function () {
            $container.masonry({
                itemSelector: '.box',
                isAnimated: true
            });
        });
    }

    $(document).ready(function () {

        //Init jQuery Masonry layout
        init_masonry();

        // Magnific Popup
        $('.gallery-images-container').magnificPopup({
            delegate: 'a', // child items selector, by clicking on it popup will open
            type: 'image',
            gallery: {
                enabled: true,
                navigateByImgClick: true,
                preload: [0, 1] // Will preload 0 - before current, and 1 after the current image
            },
        });

        //Select menu onchange
        $("#collapsed-navbar").change(function () {
            window.location = $(this).val();
        });

    });
</script>

</body>
</html>
