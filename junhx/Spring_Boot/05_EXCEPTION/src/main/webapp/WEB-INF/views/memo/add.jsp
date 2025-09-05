<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
    <h1>/memo/add PAGE</h1>

    <form action="/memo/add" method="post">
      <div>
            <label>ID :</label> <span> ${id} </span> <br/>
            <input name="id" />
      </div>
      <div>
            <label>TEXT :</label> <span> ${text} </span> <br/>
            <textarea name="text"> </textarea>
      </div>
      <div>
            <label>WRITER :</label> <span> ${writer} </span> <br/>
            <input name="writer" />
      </div>
      <div>
            <label>CREATEAT :</label> <span> ${createAt} </span> <br/>
            <input type="datetime-local" name="createAt" />
      </div>
      <div>
            <label>DATA_TEST :</label> <span> ${data_test} </span> <br/>
            <input name="data_test"  placeHolder="yyyy#MM#dd 형식으로 날짜를 입력하세요" />
      </div>
      <div>
            <button>메모추가</button>
      </div>
    </form>

</body>
</html>