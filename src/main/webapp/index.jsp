<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
    <form action="/user">
        <h3>User data entry</h3>
        <div>Login</div>
        <input type="text" name="login" id="login" size="20" required/>

        <div>Password</div>
        <input type="password" name="password" id="password" size="30" required/>

        <div>Name</div>
        <input type="text" name="name" id="name" size="20" required/>

        <div>EMail</div>
        <input type="text" name="email" id="email" size="40" required/>

        <div>Gender</div>
        <div><input type="radio" name="gender" value="Not specify" checked/><label>Not specify</label></div>
        <div><input type="radio" name="gender" value="Male"/><label>Male</label></div>
        <div><input type="radio" name="gender" value="Female"/><label>Female</label></div>
        <div><input type="radio" name="gender" value="Other"/><label>Other</label></div>

        <div>Birthday</div>
        <input type="date" name="bday" id="bday">

        <div>Favorite color</div>
        <select name="favColor" id="favColor" required>
            <option value="Not specify">Not specify</option>
            <option value="Red" style="background-color: Red;">Red</option>
            <option value="Orange" style="background-color: Orange;">Orange</option>
            <option value="Yellow" style="background-color: Yellow;">Yellow</option>
            <option value="Green" style="background-color: Green;">Green</option>
            <option value="Blue" style="background-color: Blue;">Blue</option>
            <option value="Purple" style="background-color: Purple;">Purple</option>
            <option value="Pink" style="background-color: Pink;">Pink</option>
            <option value="Black" style="background-color: Black;">Black</option>
            <option value="Brown" style="background-color: Brown;">Brown</option>
            <option value="Beige" style="background-color: Beige;">Beige</option>
            <option value="White" style="background-color: White;">White</option>
        </select>

        <div>Mailing</div>
        <input type="checkbox" name="mailing" id="mailing" value="Agree"/>

        <div>User agreement</div>
        <input type="checkbox" name="usrAgrmnt" id="usrAgrmnt" value="Agree" required/>

        <div>Description</div>
        <textarea name="description" id="description" size="100"></textarea>

        <input type="submit" value="MyServlet">
    </form>
</body>
</html>
