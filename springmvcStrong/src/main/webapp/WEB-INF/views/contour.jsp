<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contour</title>
</head>
<body>
<input type="text" id="fileName"><button onclick="gen($('#fileName').val())">GEN</button>

<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-1.10.1.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/d3/d3.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/d3/conrec.js"></script>
<script type="text/javascript">
var colorRange = ["rgb(153,229,127)", "rgb(0,175,239)","rgb(0,95,215)","rgb(255,255,155)","rgb(255,255,0)","rgb(255,153,25)","rgb(255,102,25)","rgb(255,0,0)","rgb(191,0,0)","rgb(127,7,0)"];
var rate = [0,0.18,0.24,0.35,0.42,0.53,0.61,0.75,0.9,1];
var rangeO = [1,1000,2500,5400,6500,8000,10000,15000,20000,500000];
//var range = [0,4559,6079,8865,10638,13424,15451,18997,22797,25330];
var range = new Array();
var range2 = [0,14995,19994,29158,34990,44154,50819,62482,74979,83310];
var range3 = [0,3393,4524,6598,7918,9992,11500,14140,16968,18854];

function gen(filename) {
	$.get(
			"<%=request.getContextPath()%>/contourByFilename/"+filename,
			{},
			function(data,status) {
				var d = data.data;
				var max = data.maxCount;
				d3.select('title').text('最大案件数:'+max);
				renderData(d,max,data);
			},'json'
		);
}


function renderData(data,max,obj) {
	/*  range.push(rate.map(function(d){
		return parseInt(d*max);
	}));
	alert(range);   */
	var cliff = -max*2;
	data.push(d3.range(data[0].length).map(function() { return cliff; }));
	data.unshift(d3.range(data[0].length).map(function() { return cliff; }));
	data.forEach(function(d) {
	  d.push(cliff);
	  d.unshift(cliff);
	});
	var c = new Conrec(),
	    xs = d3.range(0, data[0].length),
	    //xs = d3.range(obj.minX, obj.maxX),
	    ys = d3.range(0, data.length),
	   // ys = d3.range(obj.minY, obj.maxY),
	    zs = d3.range(0, max),
	    w = window.screen.availWidth,
	    h = window.screen.availHeight,
	  //  x = d3.scale.linear().range([obj.minX,obj.maxX ]).domain([0, data[0].length]),
	  x = d3.scale.linear().range([0,w]).domain([0, data[0].length]),
		// y = d3.scale.linear().range([obj.maxY, obj.minY]).domain([0, data.length]),
	   y = d3.scale.linear().range([h, 0]).domain([0, data.length]),
	   //colours = d3.scale.linear().domain([0,40000]).range(["rgb(153,229,127,1)","rgb(255,102,25,1)"]);
	    colours = d3.scale.linear().domain(rangeO).range(colorRange);
	c.contour(data, 0, xs.length-1, 0, ys.length-1, xs, ys, zs.length, zs);
	d3.select("body").append("svg:svg")
	    .attr("width", w)
	    .attr("height", h)
	  .selectAll("path").data(c.contourList())
	  .enter().append("svg:path")
	    .style("fill",function(d) { return colours(d.level);})
	    .style("stroke","rgba(1,1,1,0)")
	    .attr("d",d3.svg.line()
	      .x(function(d) { return x(d.x); })
	      .y(function(d) { return y(d.y); })
	    );
}




</script>
</body>
</html>