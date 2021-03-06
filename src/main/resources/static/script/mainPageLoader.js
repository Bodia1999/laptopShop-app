
let pageRequest = {
    page: 0,
    size: 12,
    sort: {
        direction: 'ASC',
        fieldName: 'name'
    }};

$.ajax({
    url: 'http://localhost:8000/laptop/page',
    type: 'POST',
    contentType: 'application/json',
    data: JSON.stringify(pageRequest),
    success: (page) => {
        $('.container').html('');
        for (let laptop of page.content) {
            appendProduct(laptop);
        }
    },
    error: (e) => {
        console.log(e)
    }
});


function appendProduct(prod) {

    let container = $('.container');

    container.append(`
        <div class="product">
           <!--<div class="product-image" style="background-image: url(https://s.4pda.to/FXOw91qnJGBZYbwuumPLtusBjioW.jpg)">-->
           <a href="../product/productPage.html" ><div class="product-image" style="background-image: url(http://localhost:8000/img/${prod.imageDirection})"></a>

                <!--<a href="#" class="listing-item__img-container">-->
                <!--<img src="img/macbook.jpg"  class="item-image">-->
                <!--</a>-->

                </div>
                <p class="product-name">
                <a href="../product/productPage.html"  >
                ${prod.makeName} ${prod.model}     <span class="identification-code" style="color:white;">${prod.id}</span>
                </a>
                </p>


                <ul class="list-short-description">

                <li>
                <span class="processor-name">Processor</span>: <span class="">${prod.processor.name} ${prod.processor.model}</span>

                </li>
                <li>
                <span class="processor-name">Ram</span>: <span class="">${prod.ram.volumeOfMemory}GB</span>

                </li>
                <li>
                <span class="processor-name">Graphic Card</span>: <span>${prod.graphicCard.name} ${prod.graphicCard.model}</span>
                </li>
                <li>
<span class="numb">${prod.price}</span><span class="currency">$</span>
</li>
                </ul>





                </div>`)};