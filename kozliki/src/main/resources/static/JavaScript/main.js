function myFunction() {
    let x = document.getElementById("myLinks");
    if (x.style.display === "block") {
        x.style.display = "none";
    } else {
        x.style.display = "block";
    }
}

const original = document.getElementById("skansen_text").innerHTML

function change_skansen(){
    document.getElementById("skansen_text").innerHTML = original;
}

function change_imprezy(){
    document.getElementById("skansen_text").innerHTML = document.getElementById("imprezy_text").innerHTML;
}

function change_aktualnosci(){
    document.getElementById("skansen_text").innerHTML = document.getElementById("aktualnosci_text").innerHTML;
}

function change_okolica_sport(){
    document.getElementById("skansen_text").innerHTML = document.getElementById("okolica_sport_txt").innerHTML;
}

function change_lokalizacja() {
    document.getElementById("skansen_text").innerHTML = document.getElementById("lokalizacja_text").innerHTML;
}

function change_statut() {
    document.getElementById("skansen_text").innerHTML = document.getElementById("statut_text").innerHTML;
}

function change_sprawozdania() {
    document.getElementById("skansen_text").innerHTML = document.getElementById("sprawozdania_text").innerHTML;
}

function change_nrRachunku() {
    document.getElementById("skansen_text").innerHTML = document.getElementById("nrRachunku_text").innerHTML;
}
function change_oNas() {
    document.getElementById("skansen_text").innerHTML = document.getElementById("oNas_content").innerHTML;
}

