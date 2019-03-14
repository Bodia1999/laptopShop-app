

    let pageRequest = {
        page: 0,
        size: 15,
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
})


function appendProduct(prod) {
    let container = $('.container');

    container.append(`
        <div class="product">
           <div class="product-image" <!--style="background-image: url(img/macbook.jpg)-->">

             <a href="#" class="listing-item__img-container">
            <!--<img src="img/macbook.jpg"  class="item-image">-->
        </a>

           </div>
           <p class="product-name">
             <a href="/uk/shop/noutbuki_asus_f540ma-gq061t.html" class="listing-link">
                <p class="info">${prod.model}</p>
            </a>
           </p>
           <div>
             
           <ul>
             
           <li>
           <span class="processor-name">Processor</span>: <span class="">Intel</span>
             
           </li>
           <li>
           <span class="processor-name">Ram</span>: <span class="">16GB</span>
             
           </li>
           <li>
             <span class="processor-name">Graphic Card</span>: <span>Nvidia GTX1050TI</span>
           </li>
           </ul>
           </div>
           <div class="product-description">
             <div class="product-price"><div class="price__relevant">
                        <span class="numb">8499</span><span class="currency">$</span>
                </div></div>
             
           </div>`);
}