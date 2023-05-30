function run() {
	let xhr = new XMLHttpRequest();
    var url = '/bin/test/servlet';
    xhr.open("GET", url, true);
    xhr.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            console.log(this.responseText);
            let title = this.responseText;
            document.getElementById("pageTitle").innerHTML = title;
        }
    }
    xhr.send();
}
run();