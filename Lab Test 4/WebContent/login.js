function validateLogin() {
    let username = document.getElementById("usernameId").value;
    let password = document.getElementById("passwordId").value;


    if (isBlank(username)) {
        document.getElementById("usernameMsg").innerHTML = "Enter username";
        document.getElementById("usernameMsg").style.color = "red";
        return false;
    }

    if (isBlank(password)) {
        document.getElementById("passwordMsg").innerHTML = "Enter password";
        document.getElementById("passwordMsg").style.color = "red";
        return false;
    }

    return true;
}
function isBlank(val) {
    return (val.trim() == "") ? true : false;
}
