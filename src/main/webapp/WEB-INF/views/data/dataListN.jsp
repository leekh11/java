<!DOCTYPE html>
<html lang="en" class="demo-1 no-js">
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
		<meta name="viewport" content="width=device-width, initial-scale=1"> 
		<title>Shape Hover Effect with SVG | Demo 1</title>
		<meta name="description" content="Hover Effects with animated SVG Shapes using Snap.svg" />
		<meta name="keywords" content="animated svg, hover effect, grid, svg shape html, " />
		<meta name="author" content="Codrops" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/demo.css" />
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/component.css" />
		<script src="<%=request.getContextPath()%>/js/snap.svg-min.js"></script>
		<!--[if IE]>
  		<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		<style>
				.demo-1 body {
					background: #d8f3ea;
				}
		</style>
	</head>
	<body>
		<div class="container">
			<!-- Top Navigation -->

			<header class="codrops-header" style="color: black; margin: 40px auto;">
				<h1>Theme<span>여행.. NextOn<br><a href="#">main</a></span></h1>	

			</header>
			<section id="grid" class="grid clearfix" style=" margin: 10px auto 120px; max-width: 1500px; width: 90%; position: relative; left: 120px;">
				<a href="#" data-path-hover="m 180,34.57627 -180,0 L 0,0 180,0 z">
					<figure>
						<img src="<%=request.getContextPath()%>/img/1.png" />
						<svg viewBox="0 0 180 320" preserveAspectRatio="none"><path d="M 180,160 0,218 0,0 180,0 z"/></svg>
						<figcaption>
							<h2>체험</h2>
							<p></p>
							<button>View</button>
						</figcaption>
					</figure>
				</a>
				<a href="#" data-path-hover="m 180,34.57627 -180,0 L 0,0 180,0 z">
					<figure>
						<img src="<%=request.getContextPath()%>/img/3.png" />
						<svg viewBox="0 0 180 320" preserveAspectRatio="none"><path d="M 180,160 0,218 0,0 180,0 z"/></svg>
						<figcaption>
							<h2>축제</h2>
							<p></p>
							<button>View</button>
						</figcaption>
					</figure>
				</a>
				<a href="#" data-path-hover="m 180,34.57627 -180,0 L 0,0 180,0 z">
					<figure>
						<img src="<%=request.getContextPath()%>/img/5.png" />
						<svg viewBox="0 0 180 320" preserveAspectRatio="none"><path d="M 180,160 0,218 0,0 180,0 z"/></svg>
						<figcaption>
							<h2>맛집</h2>
							<p></p>
							<button>View</button>
						</figcaption>
					</figure>
				</a>
				<a href="#" data-path-hover="m 180,34.57627 -180,0 L 0,0 180,0 z">
					<figure>
						<img src="<%=request.getContextPath()%>/img/7.png" />
						<svg viewBox="0 0 180 320" preserveAspectRatio="none"><path d="M 180,160 0,218 0,0 180,0 z"/></svg>
						<figcaption>
							<h2>명소</h2>
							<p></p>
							<button>View</button>
						</figcaption>
					</figure>
				</a>
				<a href="#" data-path-hover="m 180,34.57627 -180,0 L 0,0 180,0 z">
					<figure>
						<img src="<%=request.getContextPath()%>/img/2.png" />
						<svg viewBox="0 0 180 320" preserveAspectRatio="none"><path d="M 180,160 0,218 0,0 180,0 z"/></svg>
						<figcaption>
							<h2>숙박</h2>
							<p></p>
							<button>View</button>
						</figcaption>
					</figure>
				</a>
			</section>
		</div><!-- /container -->
		<script>
			(function() {
	
				function init() {
					var speed = 250,
						easing = mina.easeinout;

					[].slice.call ( document.querySelectorAll( '#grid > a' ) ).forEach( function( el ) {
						var s = Snap( el.querySelector( 'svg' ) ), path = s.select( 'path' ),
							pathConfig = {
								from : path.attr( 'd' ),
								to : el.getAttribute( 'data-path-hover' )
							};

						el.addEventListener( 'mouseenter', function() {
							path.animate( { 'path' : pathConfig.to }, speed, easing );
						} );

						el.addEventListener( 'mouseleave', function() {
							path.animate( { 'path' : pathConfig.from }, speed, easing );
						} );
					} );
				}

				init();

			})();
		</script>
	</body>
</html>