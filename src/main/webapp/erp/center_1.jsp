<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type='text/css' rel='stylesheet'
	href='<%=contextPath%>/js/movediv/movediv.css' />
<script type='text/javascript'
	src='<%=contextPath%>/js/movediv/movediv.js'></script>
<script type="text/javascript"
	src="<%=contextPath%>/dwr/interface/dwrMoblieSmsService.js"></script>
<script type="text/javascript"
	src="<%=contextPath%>/dwr/interface/dwrMailService.js"></script>
<script src="<%=contextPath%>/js/echarts/build/dist/echarts.js"></script>

<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<title>首页</title>
<script type="text/javascript">
	window.onload = function() {
		initTemperatureCharts();
		initHeatCharts();
		initOfflineCharts();
		initInfoCharts();
	}

	function initTemperatureCharts() {
		// 路径配置
		require.config({
			paths : {
				echarts : '<%=contextPath%>/js/echarts/build/dist'
			}
		});

		// 使用
		require([ 'echarts', 'echarts/chart/pie', 'echarts/chart/funnel'
		], function(ec) {
			// 基于准备好的dom，初始化echarts图表
			var myChart = ec.init(document.getElementById('temperature_win_div'));

			var option = {
				title : {
					text : '',
					subtext : '',
					x : 'center'
				},
				tooltip : {
					trigger : 'item',
					formatter : "{a} <br/>{b} : {c} ({d}%)"
				},
				legend : {
					orient : 'vertical',
					x : 'left',
					data : [ '>25', '20-25', '16-20', '<16' ]
				},
				toolbox : {
					show : true,
					feature : {
						mark : {
							show : false
						},
						dataView : {
							show : true,
							readOnly : false
						},
						magicType : {
							show : true,
							type : [ 'pie', 'funnel' ],
							option : {
								funnel : {
									x : '25%',
									width : '50%',
									funnelAlign : 'left',
									max : 1548
								}
							}
						},
						restore : {
							show : false
						},
						saveAsImage : {
							show : true
						}
					}
				},
				calculable : true,
				series : [ {
					name : '温度分布',
					type : 'pie',
					radius : '60%',
					center : [ '50%', '50%' ],
					data : [ {
						value : 35,
						name : '>25'
					}, {
						value : 310,
						name : '20-25'
					}, {
						value : 234,
						name : '16-20'
					}, {
						value : 135,
						name : '<16'
					}
					 ]
				} ]
			};

			// 为echarts对象加载数据 
			myChart.setOption(option);
		});

	}

	function initHeatCharts() {
		// 路径配置
		require.config({
			paths : {
				echarts : '<%=contextPath%>/js/echarts/build/dist'
			}
		});

		// 使用
		require([ 'echarts', 'echarts/chart/line', 'echarts/chart/bar'
		], function(ec) {
			// 基于准备好的dom，初始化echarts图表
			var myChart = ec.init(document.getElementById('heat_win_div'));

			var option = {
				    title : {
				        text: '',
				        subtext: ''
				    },
				    tooltip : {
				        trigger: 'axis'
				    },
				    legend: {
				        data:['2014','2015']
				    },
				    toolbox: {
				        show : true,
				        feature : {
				            mark : {show: false},
				            dataView : {show: true, readOnly: false},
				            magicType : {show: true, type: ['line', 'bar']},
				            restore : {show: false},
				            saveAsImage : {show: true}
				        }
				    },
				    calculable : true,
				    xAxis : [
				        {
				            type : 'category',
				            data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
				        }
				    ],
				    yAxis : [
				        {
				            type : 'value'
				        }
				    ],
				    series : [
				        {
				            name:'2014',
				            type:'bar',
				            data:[200, 490, 700, 2320, 2560, 7670, 13560, 16220, 3260, 2000, 640, 330],
				            markPoint : {
				                data : [
				                    {type : 'max', name: '最大值'},
				                    {type : 'min', name: '最小值'}
				                ]
				            },
				            markLine : {
				                data : [
				                    {type : 'average', name: '平均值'}
				                ]
				            }
				        },
				        {
				            name:'2015',
				            type:'bar',
				            data:[260, 590, 900, 2640, 2870, 7070, 17560, 18220, 4807, 1880, 600, 230],
				            markPoint : {
				                data : [
				                    {name : '年最高', value : 18220, xAxis: 7, yAxis: 18300, symbolSize:18},
				                    {name : '年最低', value : 230, xAxis: 11, yAxis: 3}
				                ]
				            },
				            markLine : {
				                data : [
				                    {type : 'average', name : '平均值'}
				                ]
				            }
				        }
				    ]
				};

			// 为echarts对象加载数据 
			myChart.setOption(option);
		});

	}

	function initOfflineCharts() {
		// 路径配置
		require.config({
			paths : {
				echarts : '<%=contextPath%>/js/echarts/build/dist'
			}
		});

		// 使用
		require([ 'echarts', 'echarts/chart/pie'
		], function(ec) {
			// 基于准备好的dom，初始化echarts图表
			var myChart = ec.init(document.getElementById('offline_win_div'));

			var option = {
				title : {
					text : '',
					subtext : '',
					x : 'center'
				},
				tooltip : {
					trigger : 'item',
					formatter : "{a} <br/>{b} : {c} ({d}%)"
				},
				legend : {
					orient : 'vertical',
					x : 'left',
					data : [ '在线', '离线' ]
				},
				toolbox : {
					show : true,
					feature : {
						mark : {
							show : false
						},
						dataView : {
							show : true,
							readOnly : false
						},
						magicType : {
							show : false,
							type : [ 'pie', 'funnel' ],
							option : {
								funnel : {
									x : '25%',
									width : '50%',
									funnelAlign : 'left',
									max : 1548
								}
							}
						},
						restore : {
							show : false
						},
						saveAsImage : {
							show : true
						}
					}
				},
				calculable : true,
				series : [ {
					name : '离线率',
					type : 'pie',
					radius : '60%',
					center : [ '50%', '50%' ],
					data : [ {
						value : 90,
						name : '在线'
					}, {
						value : 10,
						name : '离线'
					} ]
				} ]
			};

			// 为echarts对象加载数据 
			myChart.setOption(option);
		});

	}

	function initInfoCharts() {
		// 路径配置
		require.config({
			paths : {
				echarts : '<%=contextPath%>/js/echarts/build/dist'
			}
		});

		// 使用
		require([ 'echarts', 'echarts/chart/line', 'echarts/chart/bar'
		], function(ec) {
			// 基于准备好的dom，初始化echarts图表
			var myChart = ec.init(document.getElementById('info_win_div'));

			var option = {
				    title : {
				        text: '',
				        subtext: ''
				    },
				    tooltip : {
				        trigger: 'axis'
				    },
				    legend: {
				        data:['今天', '昨天']
				    },
				    toolbox: {
				        show : true,
				        feature : {
				            mark : {show: false},
				            dataView : {show: true, readOnly: false},
				            magicType: {show: true, type: ['line', 'bar']},
				            restore : {show: false},
				            saveAsImage : {show: true}
				        }
				    },
				    calculable : true,
				    xAxis : [
				        {
				            type : 'value',
				            boundaryGap : [0, 0.01]
				        }
				    ],
				    yAxis : [
				        {
				            type : 'category',
				            data : ['热表流量异常数','采集器掉线数','低温报警数','温控面板与控制器失联数','高温报警数','热表通讯故障数']
				        }
				    ],
				    series : [
				        {
				            name:'今天',
				            type:'bar',
				            data:[209, 11, 1506, 1684, 98, 0]
				        },
				        {
				            name:'昨天',
				            type:'bar',
				            data:[180, 20, 2000, 1500, 45, 3]
				        }
				    ]
				};

			// 为echarts对象加载数据 
			myChart.setOption(option);
		});

	}
</script>
<style type="text/css">
button {
	position: relative;
	border: 0;
	padding: 0;
	cursor: pointer;
	overflow: visible; /* removes extra side padding in IE */
	margin-bottom: 10px
}

button span {
	position: relative;
	display: block;
	white-space: nowrap;
	width: 100px;
}

button.submitBtn {
	padding: 0 8px 0 0;
	margin-right: 20px;
	font-size: 13px;
	text-align: center;
	background: transparent url(<%=contextPath%>/images/btn_desk_right.png)
		no-repeat right top;
}

button.submitBtn span {
	padding-left: 18px;
	padding-right: 10px;
	padding-top: 12px;
	height: 40px;
	background: transparent url(<%=contextPath%>/images/btn_desk_left.png)
		no-repeat left top;
	color: #054477;
}
</style>



</head>
<body>
<br/>
<table width="100%" cellpadding="0" cellspacing="0">

	<tr>
		<td width="10px"></td>
		<td>
		<div id="container" style="width:490px;height:350px">
			<div class="dragLayer" id="temperature_win" style="width:100%;height:100%">
				<div class="dragHeader">
					<div class="dragleft"
						style="background: url('<%=contextPath%>/images/projectimg/chart_bar.png') 3px no-repeat;">
							温度分布
					</div>
				</div>
				<br/>
				<div id="temperature_win_div" style="height:260px; width:485px"></div>
				<div id="temperature_win_search" style="width:100%; height:50px; text-align:center">
					<br/>
					<table>
						<tr>
							<td>
								<select id="temperature_area">  
  									<option value ="1" selected="selected">小区1</option>  
  									<option value ="2">小区2</option>  
  									<option value="3">小区3</option>  
  									<option value="4">小区4</option>  
								</select>  
							</td>
							<td>
								<btn:btn onclick="initTemperatureCharts();" value="查询 " />
							</td>
						</tr>
					</table>
					
					
				</div>
			</div>
		</div>
		</td>
		<td>
		<div id="container" style="width:490px;height:350px">
			<div class="dragLayer" id="heat_win" style="width:100%;height:100%">
				<div class="dragHeader">
					<div class="dragleft"
						style="background: url('<%=contextPath%>/images/projectimg/chart_bar.png') 3px no-repeat;">
							用热趋势
					</div>
				</div>
				<br/>
				<div id="heat_win_div" style="height:260px; width:485px"></div>
				<div id="heat_win_search" style="width:100%; height:50px">
				<br/>
					<table>
						<tr>
							<td>
								<select id="heat_area">  
  									<option value ="1" selected="selected">小区1</option>  
  									<option value ="2">小区2</option>  
  									<option value="3">小区3</option>  
  									<option value="4">小区4</option>  
								</select>  
							</td>
							<td>
								<btn:btn onclick="initHeatCharts();" value="查询 " />
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		</td>
	</tr>
	<tr>
		<td><br/></td>
		<td><br/></td>
	</tr>
	<tr>
		<td width="10px"></td>
		<td>
		<div id="container" style="width:490px;height:350px">
			<div class="dragLayer" id="offline_win" style="width:100%;height:100%">
				<div class="dragHeader">
					<div class="dragleft"
						style="background: url('<%=contextPath%>/images/projectimg/chart_bar.png') 3px no-repeat;">
							采集器离线率
					</div>
				</div>
				<br/>
				<div id="offline_win_div" style="height:260px; width:485px"></div>
				<div id="offline_win_search" style="width:100%; height:50px; text-align:center">
					<br/>
					<table>
						<tr>
							<td>
								<select id="offline_area">  
  									<option value ="1" selected="selected">小区1</option>  
  									<option value ="2">小区2</option>  
  									<option value="3">小区3</option>  
  									<option value="4">小区4</option>  
								</select>  
							</td>
							<td>
								<btn:btn onclick="initOfflineCharts();" value="查询 " />
							</td>
						</tr>
					</table>
					
					
				</div>
			</div>
		</div>
		</td>
		<td>
		<div id="container" style="width:490px;height:350px">
			<div class="dragLayer" style="width:100%;height:100%">
				<div class="dragHeader">
					<div class="dragleft"
						style="background: url('<%=contextPath%>/images/projectimg/chart_bar.png') 3px no-repeat;">
							数据信息
					</div>
				</div>
				<br/>
				<div id="info_win_div" style="height:260px; width:485px"></div>
				<div id="info_win_search" style="width:100%; height:50px; text-align:center">
					<br/>
					<table>
						<tr>
							<td>
								<select id="info_area">  
  									<option value ="1" selected="selected">小区1</option>  
  									<option value ="2">小区2</option>  
  									<option value="3">小区3</option>  
  									<option value="4">小区4</option>  
								</select>  
							</td>
							<td>
								<btn:btn onclick="initInfoCharts();" value="查询 " />
							</td>
						</tr>
					</table>
					
					
				</div>
			</div>
		</div>
		</td>
	</tr>
	
</table>

</body>
</html>