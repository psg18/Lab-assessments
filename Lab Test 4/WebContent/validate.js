function validate() {
    let name = document.getElementById("trainee_name").value;
    let branch = document.getElementById("branch").value;
    let percentage = document.getElementById("percentage").value;


    if (isBlank(name)) {
        document.getElementById("nameMsg").innerHTML = "Enter name";
        document.getElementById("nameMsg").style.color = "red";
        return false;
    }

    if (isBlank(branch)) {
        document.getElementById("branchMsg").innerHTML = "Enter city";
        document.getElementById("branchMsg").style.color = "red";
        return false;
    }

    if (isBlank(percentage)) {
        document.getElementById("perMsg").innerHTML = "Enter desi";
        document.getElementById("perMsg").style.color = "red";
        return false;
    }

 
    return true;
}
function isBlank(val) {
    return (val.trim() == "") ? true : false;
}
