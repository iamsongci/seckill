<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>商品列表</title>
        <link rel="stylesheet" href="/css/bootstrap.min.css" />
    </head>
<body>
<div class="container">
    <nav class="navbar navbar-default" role="navigation">
						<div class="collapse navbar-collapse">
							<ul class="nav navbar-nav">
								<li>
									<a href="#">电商秒杀平台</a>
								</li>
							</ul>
							<ul class="nav navbar-nav navbar-right">
								<li>
									<a href="#">登录</a>
								</li>
								<li>
									<a href="#">注册</a>
								</li>
							</ul>
						</div>
					</nav>
					<nav class="navbar navbar-default" role="navigation">
						<div class="collapse navbar-collapse">
							<ul class="nav navbar-nav">
								<li>
									<a href="#">电商秒杀平台</a>
								</li>
							</ul>
							<ul class="nav navbar-nav navbar-right">
								<li>
									<a href="#">我的店铺</a>
								</li>
								<li>
									<a href="#">购物车</a>
								</li>
								<li>
									<a href="#">我的订单</a>
								</li>
								<li>
									<a href="#">欢迎_登录_</a>
								</li>
								<li>
									<a href="#">余额1000</a>
								</li>
							</ul>
						</div>
					</nav>
				<div class="col-md-12">
						<div class="col-md-6">
						<img src="../img/Tulip.jpg">
						</div>
						<div class="col-md-6">
						<h3>郁金香     <a class="btn btn-danger" href="#">秒杀</a></h3>
						<h3>价格：</h3>
						<h3>邮费：</h3>
						<h3>剩余：</h3>
						<div class="col-md-12">
						离开始还剩30:00
						<br>
						<a class="btn btn-default" href="#">加入购物车</a><a class="btn btn-default" href="#">购买</a>	
						</div>
						</div>
				</div>
				<h2>商品描述</h2>
				<div class="col-md-12">
						<img alt="Bootstrap Thumbnail Second" src="../img/Tulip.jpg">
				</div>				
</div>

</body>
<script type="text/javascript" src="/js/jquery.min.js" ></script>
<script type="text/javascript" src="/js/bootstrap.min.js" ></script>
</html>