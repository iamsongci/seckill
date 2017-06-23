<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>登录</title>
        <link rel="stylesheet" href="./css/bootstrap.min.css" />
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
									<a href="tologin.do">登录</a>
								</li>
								<li>
									<a href="tosignup.do">注册</a>
								</li>
							</ul>
						</div>
					</nav>
		<h2>商品发布</h2>
	<form class="form-horizontal">
      <div class="control-group">
        <label class="control-label">商品名称：</label>
        <div class="controls">
          <input type="text" placeholder="4—20个字母和数字组合">
        </div>
      </div>
      <div class="control-group">
        <label class="control-label">价格：</label>
        <div class="controls">
          <input type="text" placeholder="最大9999999999.99">
        </div>
      </div>
        <div class="control-group">
        <label class="control-label">邮费：</label>
        <div class="controls">
          <input type="text" placeholder="最大99999.99">
        </div>
      </div>
      <div class="control-group">
        <label class="control-label">库存：</label>
        <div class="controls">
          <input type="text" placeholder="最大99999">
        </div>
      </div>
      
      <div class="control-group">
        <div class="controls">
          <button  class="btn">回到首页</button>
          <button type="submit" class="btn">登录</button>
        </div>
      </div>
    </form>
    </div>
 </body>
<script type="text/javascript" src="./js/jquery.min.js" ></script>
<script type="text/javascript" src="./js/bootstrap.min.js" ></script>
</html>