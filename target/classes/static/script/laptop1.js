var mainUrl = "http://localhost:8000";

getAllLaptops();
setModalConfiguration();
setActionOnCreateBtn();
$("#btnCreateLaptop").show();
$("#btnUpdateLaptop").hide();


//start when load page PS reload page for triggered http request
function getAllLaptops() {
    $.ajax({
        url: mainUrl + "/laptop",
        type: "GET",

        contentType: "application/json",
        success: function (dataResponse) {
            console.log(dataResponse);
            setLaptopsToTable(dataResponse);
            setActionOnDeleteButtons();
            setActionOnUpdateButton();
        },
        error: function (error) {
            alert("Something went wrong");
        }
    });
}

function setLaptopsToTable(laptops) {
    for (var i = 0; i < laptops.length; i++) {
        setLaptopToTable(laptops[i]);
    }
}

function setLaptopToTable(laptop) {
    var tableOfLaptops = $("#laptops");
    tableOfLaptops.append('<tr>' +
        '<td>' + laptop.id + '</td>' +
        '<td>' + laptop.model + '</td>' +
        '<td>' + laptop.makeId + '</td>' +
        '<td>' + laptop.graphicCardId + '</td>' +
        '<td>' + laptop.ramId + '</td>' +
        '<td>' + laptop.corpsId + '</td>' +
        '<td>' + laptop.memoryId + '</td>' +
        '<td>' + laptop.processorId + '</td>' +
        '<td>' + laptop.screenId + '</td>' +
        '<td>' + laptop.price + '</td>' +
        '<td>' + laptop.availabilityOfWIFI + '</td>' +
        '<td>' + laptop.availabilityOfBluetooth + '</td>' +
        '<td>' + laptop.availabilityOfUSBTypeC + '</td>' +
        '<td>' + laptop.availabilityOfUSBSecondGeneration + '</td>' +
        '<td>' + laptop.availabilityOfUSBThirdGeneration + '</td>' +
        '<td>' + laptop.availabilityOfHDMI + '</td>' +
        '<td>' + laptop.availabilityOfLAN + '</td>' +
        '<td>' + laptop.availabilityOfAUX + '</td>' +
        '<td>' + '<a href="'+laptop.imageDirection+'" target="_blank"><button class="photo-button" style="width:60px;">Photo</button></a>'+ '</td>' +
        '<td>' + '<a href="'+laptop.descriptionImagePath1+'" target="_blank"><button class="photo-button" style="width:60px;">Photo</button></a>'+ '</td>' +
        '<td>' + '<a href="'+laptop.descriptionImagePath2+'" target="_blank"><button class="photo-button" style="width:60px;">Photo</button></a>'+ '</td>' +
        '<td>' + '<a href="'+laptop.descriptionImagePath3+'" target="_blank"><button class="photo-button" style="width:60px;">Photo</button></a>'+ '</td>' +
        '<td><button class="button" value="' + laptop.id + '">Delete</button></td>' +
        '<td><button class="buttonToUpdate" value="' + laptop.id + '">Update</button></td>' +
        '</tr>');
}

function uuidv4() {
    return ([1e7] + -1e3 + -4e3 + -8e3 + -1e11).replace(/[018]/g, c =>
        (c ^ crypto.getRandomValues(new Uint8Array(1))[0] & 15 >> c / 4).toString(16)
    ) + ".jpg"
}

$('#sendFile1').click(function () {
    var imageDirecton = document.getElementById("mainImageDirection").files[0];
    getBase64(imageDirecton).then(data => {
        writeFileToStorage1(data);
    });

});

$('#sendFile2').click(function () {
    var descriptionImagePath1 = document.getElementById("firstImageDirection").files[0];
    getBase64(descriptionImagePath1).then(data => {
        writeFileToStorage2(data);
    });
});

$('#sendFile3').click(function () {
    var descriptionImagePath2 = document.getElementById("secondImageDirection").files[0];
    getBase64(descriptionImagePath2).then(data => {
        writeFileToStorage3(data);
    });
});

$('#sendFile4').click(function () {
    var descriptionImagePath3 = document.getElementById("thirdImageDirection").files[0];
    getBase64(descriptionImagePath3).then(data => {
        writeFileToStorage4(data);
    });
});

function setActionOnCreateBtn() {
    $("#btnCreateLaptop").show();
    $("#btnCreateLaptop").click(function () {
        //console.log("I am here");



        var model = $("#model").val();

        var makeId = $("#makeId").val();
        var graphicCardId = $("#graphicCardId").val();
        var ramId = $("#ramId").val();
        var corpsId = $("#corpsId").val();
        var memoryId = $("#memoryId").val();
        var processorId = $("#processorId").val();
        var screenId = $("#screenId").val();
        var description1 = $('#description1').val();
        var description2 = $('#description2').val();
        var description3 = $('#description3').val();
        var price= $('#price').val();


        var availabilityOfWIFI = $("input[name='availabilityOfWIFI']:checked").val();
        var availabilityOfBluetooth = $("input[name='availabilityOfBluetooth']:checked").val();
        var availabilityOfUSBTypeC = $("input[name='availabilityOfTypeC']:checked").val();

        var availabilityOfUSBSecondGeneration = $("input[name='availabilityOfUSBSecondGeneration']:checked").val();

        var availabilityOfUSBThirdGeneration = $("input[name='availabilityOfUSBThirdGeneration']:checked").val();
        var availabilityOfHDMI = $("input[name='availabilityOfHDMI']:checked").val();
        var availabilityOfLAN = $("input[name='availabilityOfLAN']:checked").val();
        var availabilityOfAUX = $("input[name='availabilityOfAUX']:checked").val();
//            if (firstName != null && lastName != null && age != null) {


        var newLaptop = {
            "model": model,
            "makeId": makeId,
            "graphicCardId": graphicCardId,
            "ramId": ramId,
            "corpsId": corpsId,
            "memoryId": memoryId,
            "processorId": processorId,
            "screenId": screenId,
            "availabilityOfWIFI": availabilityOfWIFI,
            "availabilityOfBluetooth": availabilityOfBluetooth,
            "availabilityOfUSBTypeC": availabilityOfUSBTypeC,
            "availabilityOfUSBSecondGeneration": availabilityOfUSBSecondGeneration,
            "availabilityOfUSBThirdGeneration": availabilityOfUSBThirdGeneration,
            "availabilityOfHDMI": availabilityOfHDMI,
            "availabilityOfLAN": availabilityOfLAN,
            "availabilityOfAUX": availabilityOfAUX,
            "imageDirection": window.localStorage.getItem("url1"),
            "descriptionImagePath1": window.localStorage.getItem("url2"),
            "descriptionImagePath2": window.localStorage.getItem("url3"),
            "descriptionImagePath3": window.localStorage.getItem("url4"),
            "descriptionFirstParagraph": description1,
            "descriptionSecondParagraph": description2,
            "descriptionThirdParagraph": description3,
            "price":parseFloat(price)


        };

        $.ajax({
            url: mainUrl + "/laptop",
            type: "POST",
            headers:{
                'Authorize':window.localStorage.getItem('token')
            },
            contentType: "application/json",
            data: JSON.stringify(newLaptop),
            success: function (data) {
                location.reload();
            },
            error: function (error) {
                // location.reload();
                alert(error.message);
            }
        });
//            } else {
//                alert("Всі поля повинні бути заповнені")
//            }
    });
}

// function gettingFile(file) {
//     getBase64(file).then(data => {
//
//         //work with data as src of file
//         let request = {
//             //fileName: "someCustomFileName",
//             data: data
//         };
//
//         $.ajax({
//             url: "http://localhost:8000/photo/upload",
//             type: "POST",
//             contentType: "application/json",
//             data: JSON.stringify(request),
//             success: function (dataResponse) {
//                 return dataResponse;
//
//             },
//             error: function (error) {
//                 alert(error.message);
//             }
//         });
//     });
// }

function deletingProductForOrderWithLaptopId(id) {
    $.ajax({
        url: mainUrl + "/productForOrder/deleteByLaptopId?id=" + id,
        type: "DELETE",
        headers:{
            'Authorize':window.localStorage.getItem('token')
        },
        success: function (data) {
            // location.reload();
        },
        error: function (error) {
            // location.reload();
            // alert(error.message);
        }
    });
}

//delete process
function setActionOnDeleteButtons() {
    $(".button").each(function (index) {
        $(this).click(function () {
            deletingProductForOrderWithLaptopId($(this).val());
            $.ajax({
                url: mainUrl + "/laptop?id=" + $(this).val(),
                type: "DELETE",
                headers:{
                    'Authorize':window.localStorage.getItem('token')
                },
                success: function (data) {
                    location.reload();
                },
                error: function (error) {
                    // location.reload();
                    alert(error.message);
                }
            });

        })
    })

}

function setActionOnUpdateButton() {

    $(".buttonToUpdate").each(function (index) {
        var identifier;
        identifier = $(this).val();
        $(this).click(function () {
            $.ajax({
                url: mainUrl + "/laptop/findOne?id=" + $(this).val(),
                type: "POST",

                contentType: "application/json",
                success: function (dataResponse) {
                    // var parse = JSON.parse(dataResponse);
                    $("#name").val(dataResponse.name);
                    $("#model").val(dataResponse.model);
                    $("#makeId").val(dataResponse.makeId);
                    $("#graphicCardId").val(dataResponse.graphicCardId);
                    $("#ramId").val(dataResponse.ramId);
                    $("#corpsId").val(dataResponse.corpsId);
                    $("#memoryId").val(dataResponse.memoryId);
                    $("#processorId").val(dataResponse.processorId);
                    $("#screenId").val(dataResponse.screenId);
                    $('#description1').val(dataResponse.descriptionFirstParagraph);
                    $('#description2').val(dataResponse.descriptionSecondParagraph);
                    $('#description3').val(dataResponse.descriptionThirdParagraph);
                    // $('#description1').val(dataResponse.descriptio);
                    // $('#description2').val();
                    // $('#description3').val();
                    $('#price').val(dataResponse.price);
                    // $("#availabilityOfWIFI").val(dataResponse.availabilityOfWIFI);
                    // $("#availabilityOfBluetooth").val(dataResponse.availabilityOfBluetooth);
                    // $("#availabilityOfUSBTypeC").val(dataResponse.availabilityOfUSBTypeC);
                    // $("#availabilityOfUSBSecondGeneration").val(dataResponse.availabilityOfUSBSecondGeneration);
                    // $("#availabilityOfUSBThirdGeneration").val(dataResponse.availabilityOfUSBThirdGeneration);
                    // $("#availabilityOfHDMI").val(dataResponse.availabilityOfHDMI);
                    // $("#availabilityOfLAN").val(dataResponse.availabilityOfLAN);
                    // $("#availabilityOfAUX").val(dataResponse.availabilityOfAUX);
                    $("#btnCreateLaptop").hide();
                    $("#btnUpdateLaptop").show();
                    var elementById = document.getElementById("myModal");
                    elementById.style.display = "block";
                    $("#btnUpdateLaptop").click(function () {

                        var model = $("#model").val();
                        var makeId = $("#makeId").val();
                        var graphicCardId = $("#graphicCardId").val();
                        var ramId = $("#ramId").val();
                        var corpsId = $("#corpsId").val();
                        var memoryId = $("#memoryId").val();
                        var processorId = $("#processorId").val();
                        var screenId = $("#screenId").val();
                        var description1 = $('#description1').val();
                        var description2 = $('#description2').val();
                        var description3 = $('#description3').val();
                        var price= $('#price').val();
                        var availabilityOfWIFI = $("input[name='availabilityOfWIFI']:checked").val();

                        var availabilityOfBluetooth = $("input[name='availabilityOfBluetooth']:checked").val();

                        var availabilityOfUSBTypeC = $("input[name='availabilityOfTypeC']:checked").val();
                        var availabilityOfUSBSecondGeneration = $("input[name='availabilityOfUSBSecondGeneration']:checked").val();
                        var availabilityOfUSBThirdGeneration = $("input[name='availabilityOfUSBThirdGeneration']:checked").val();
                        var availabilityOfHDMI = $("input[name='availabilityOfHDMI']:checked").val();
                        var availabilityOfLAN = $("input[name='availabilityOfLAN']:checked").val();
                        var availabilityOfAUX = $("input[name='availabilityOfAUX']:checked").val();

//            if (firstName != null && lastName != null && age != null) {

                        var updatedLaptop = {
                            "model": model,
                            "makeId": makeId,
                            "graphicCardId": graphicCardId,
                            "ramId": ramId,
                            "corpsId": corpsId,
                            "memoryId": memoryId,
                            "processorId": processorId,
                            "screenId": screenId,
                            "availabilityOfWIFI": availabilityOfWIFI,
                            "availabilityOfBluetooth": availabilityOfBluetooth,
                            "availabilityOfUSBTypeC": availabilityOfUSBTypeC,
                            "availabilityOfUSBSecondGeneration": availabilityOfUSBSecondGeneration,
                            "availabilityOfUSBThirdGeneration": availabilityOfUSBThirdGeneration,
                            "availabilityOfHDMI": availabilityOfHDMI,
                            "availabilityOfLAN": availabilityOfLAN,
                            "availabilityOfAUX": availabilityOfAUX,
                            "imageDirection": window.localStorage.getItem("url1"),
                            "descriptionImagePath1": window.localStorage.getItem("url2"),
                            "descriptionImagePath2": window.localStorage.getItem("url3"),
                            "descriptionImagePath3": window.localStorage.getItem("url4"),
                            "descriptionFirstParagraph": description1,
                            "descriptionSecondParagraph": description2,
                            "descriptionThirdParagraph": description3,
                            "price":parseFloat(price)

                        };

                        $.ajax({
                            url: mainUrl + "/laptop?id=" + identifier,
                            type: "PUT",
                            contentType: "application/json",
                            data: JSON.stringify(updatedLaptop),
                            success: function () {
                                location.reload();
                            },
                            error: function (error) {
                                alert("Something went wrong");
                            }
                        });
//            } else {
//                alert("Всі поля повинні бути заповнені")
//            }
                    });
                }
            });
        })
    });

}


// function createImagePath(fileName){
//     return '/img/' + fileName;
// }

// function getBase64(file) {
//     return new Promise((resolve, reject) => {
//         const reader = new FileReader();
//     reader.readAsDataURL(file);
//     reader.onload = () => resolve(reader.result);
//     reader.onerror = error => reject(error);
// });
// }


// Initialize Firebase
var config = {
    apiKey: "AIzaSyCPWbaKUux7y72ZURicKoWLpw_MZJlojWc",
    authDomain: "bear-shop.firebaseapp.com",
    databaseURL: "https://bear-shop.firebaseio.com",
    projectId: "bear-shop",
    storageBucket: "bear-shop.appspot.com",
    messagingSenderId: "259030319558"
};
firebase.initializeApp(config);


var storageRef = firebase.storage().ref();


function writeFileToStorage1(file) {

    var uploadTask = storageRef.child('images/' + uuidv4()).putString(file, 'data_url');


    uploadTask.on(firebase.storage.TaskEvent.STATE_CHANGED,
        function (snapshot) {

            var progress = (snapshot.bytesTransferred / snapshot.totalBytes) * 100;
            // console.log('Upload is ' + progress + '% done');
            // switch (snapshot.state) {
            //     case firebase.storage.TaskState.PAUSED:
            //         console.log('Upload is paused');
            //         break;
            //     case firebase.storage.TaskState.RUNNING:
            //         console.log('Upload is running');
            //         break;
            // }
            move1(progress);
        }, function (error) {
            console.log(error);
        }, function () {
            // Upload completed successfully, now we can get the download URL
            uploadTask.snapshot.ref.getDownloadURL().then(function (downloadURL) {
                // console.log('File available at', downloadURL);
                window.localStorage.setItem("url1", downloadURL);
            });
        });
}function writeFileToStorage2(file) {

    var uploadTask = storageRef.child('images/' + uuidv4()).putString(file, 'data_url');


    uploadTask.on(firebase.storage.TaskEvent.STATE_CHANGED,
        function (snapshot) {

            var progress = (snapshot.bytesTransferred / snapshot.totalBytes) * 100;
            // console.log('Upload is ' + progress + '% done');
            // switch (snapshot.state) {
            //     case firebase.storage.TaskState.PAUSED:
            //         console.log('Upload is paused');
            //         break;
            //     case firebase.storage.TaskState.RUNNING:
            //         console.log('Upload is running');
            //         break;
            // }
            move2(progress);
        }, function (error) {
            console.log(error);
        }, function gettingUrl() {
            // Upload completed successfully, now we can get the download URL
            uploadTask.snapshot.ref.getDownloadURL().then(function (downloadURL) {
                // console.log('File available at', downloadURL);
                window.localStorage.setItem("url2", downloadURL);
            });
        });
}function writeFileToStorage3(file) {

    var uploadTask = storageRef.child('images/' + uuidv4()).putString(file, 'data_url');


    uploadTask.on(firebase.storage.TaskEvent.STATE_CHANGED,
        function (snapshot) {

            var progress = (snapshot.bytesTransferred / snapshot.totalBytes) * 100;
            // console.log('Upload is ' + progress + '% done');
            // switch (snapshot.state) {
            //     case firebase.storage.TaskState.PAUSED:
            //         console.log('Upload is paused');
            //         break;
            //     case firebase.storage.TaskState.RUNNING:
            //         console.log('Upload is running');
            //         break;
            // }
            move3(progress);
        }, function (error) {
            console.log(error);
        }, function () {
            // Upload completed successfully, now we can get the download URL
            uploadTask.snapshot.ref.getDownloadURL().then(function (downloadURL) {
                // console.log('File available at', downloadURL);
                window.localStorage.setItem("url3", downloadURL);
            });
        });
}function writeFileToStorage4(file) {

    var uploadTask = storageRef.child('images/' + uuidv4()).putString(file, 'data_url');


    uploadTask.on(firebase.storage.TaskEvent.STATE_CHANGED,
        function (snapshot) {

            var progress = (snapshot.bytesTransferred / snapshot.totalBytes) * 100;
            // console.log('Upload is ' + progress + '% done');
            // switch (snapshot.state) {
            //     case firebase.storage.TaskState.PAUSED:
            //         console.log('Upload is paused');
            //         break;
            //     case firebase.storage.TaskState.RUNNING:
            //         console.log('Upload is running');
            //         break;
            // }
            move4(progress);
        }, function (error) {
            console.log(error);
        }, function () {
            // Upload completed successfully, now we can get the download URL
            uploadTask.snapshot.ref.getDownloadURL().then(function (downloadURL) {
                // console.log('File available at', downloadURL);
                window.localStorage.setItem("url4", downloadURL);
            });
        });
}

function move1(myWidth) {
    var elem = document.getElementById("myBar1");
    var width = Math.round(myWidth-1);
    frame();
//  var id = setInterval(frame, 10);
    function frame() {
//    if (width >= 100) {
////      clearInterval(id);
//        console.log(uploaded);
//    } else {
        width++;
        elem.style.width = width + '%';
//      elem.innerHTML = width * 1  + '%';
        document.getElementById("demo1").innerHTML = width * 1  + '%';
//    }
    }
}function move2(myWidth) {
    var elem = document.getElementById("myBar2");
    var width = Math.round(myWidth-1);
    frame();
//  var id = setInterval(frame, 10);
    function frame() {
//    if (width >= 100) {
////      clearInterval(id);
//        console.log(uploaded);
//    } else {
        width++;
        elem.style.width = width + '%';
//      elem.innerHTML = width * 1  + '%';
        document.getElementById("demo2").innerHTML = width * 1  + '%';
//    }
    }
}function move3(myWidth) {
    var elem = document.getElementById("myBar3");
    var width = Math.round(myWidth-1);
    frame();
//  var id = setInterval(frame, 10);
    function frame() {
//    if (width >= 100) {
////      clearInterval(id);
//        console.log(uploaded);
//    } else {
        width++;
        elem.style.width = width + '%';
//      elem.innerHTML = width * 1  + '%';
        document.getElementById("demo3").innerHTML = width * 1  + '%';
//    }
    }
}function move4(myWidth) {
    var elem = document.getElementById("myBar4");
    var width = Math.round(myWidth-1);
    frame();
//  var id = setInterval(frame, 10);
    function frame() {
//    if (width >= 100) {
////      clearInterval(id);
//        console.log(uploaded);
//    } else {
        width++;
        elem.style.width = width + '%';
//      elem.innerHTML = width * 1  + '%';
        document.getElementById("demo4").innerHTML = width * 1  + '%';
//    }
    }
}


function getBase64(file) {
    return new Promise((resolve, reject) => {
        const reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = () => resolve(reader.result);
        reader.onerror = error => reject(error);
    });
}


function setModalConfiguration() {
    // Get the modal
    var modal = document.getElementById('myModal');


    // Get the button that opens the modal
    var btn = document.getElementById('openModal');


    // Get the <span> element that closes the modal
    var span = document.getElementsByClassName("close")[0];

    // When the user clicks the button, open the modal


    btn.onclick = function () {
        modal.style.display = "block";
    };


    span.onclick = function () {
        modal.style.display = "none";
    };

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function (event) {
        if (event.target == modal) {
            modal.style.display = "none";

        }
    };
}