<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
</head>
<body>
	<h2>交易窗口</h2>


	<form action="../rest/transaction" method="POST">
		<table>
			<tr>
				<td>客户信息(默认张三):</td>
				<td><input name="useName" value="张三" /></td>
			</tr>
			<tr>
				<td>交易金额：</td>
				<td><input name="tradeMoneny" value="86.5" /></td>
			</tr>
			<tr>
				<td>交易状态（默认正在交易）</td>
				<td><select name="tradeState">
						<option value="0" selected="selected">正在交易</option>
						<option value="1">交易完成</option>
				</select></td>
			</tr>
		</table>

		<input type="submit" value="提交" />
	</form>
	<a href="../rest/query">查询全部交易</a>&nbsp;&nbsp;
	<a href="../rest/query?tranStatus=交易成功">查询成功交易</a>&nbsp;&nbsp;
	<a href="../rest/query?tranStatus=交易失败">查询失败交易</a>

</body>
</html>
