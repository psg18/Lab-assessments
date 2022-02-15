function validate() {
    let name = document.getElementById("nameId").value;
    let branch = document.getElementById("branch").value;
    let percentage = document.getElementById("perId").value;


    if (isBlank(name)) {
        document.getElementById("nameMsg").innerHTML = "Enter name";
        document.getElementById("nameMsg").style.color = "red";
        return false;
    }

    if (isBlank(branch)) {
        document.getElementById("branchMsg").innerHTML = "Enter branch";
        document.getElementById("branchMsg").style.color = "red";
        return false;
    }

    if (isBlank(percentage)) {
        document.getElementById("perMsg").innerHTML = "Enter per";
        document.getElementById("perMsg").style.color = "red";
        return false;
    }

 
    return true;
}
function isBlank(val) {
    return (val.trim() == "") ? true : false;
}
