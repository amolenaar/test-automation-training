<catalog>

    <h1>Our catalog</h1>
    <ul>
        <li class="product" each={ items }>
            <p class="product-name">{ name }</p>
            <p class="product-name">&euro; { renderPrice(price) }</p>
            <a class="product-add-to-basket" href="#" onclick={ add }>Add to basket</a>
        </li>
    </ul>

    <!-- this script tag is optional -->
    <script>
        this.items = opts.items;
        this.basket = opts.basket;

        renderPrice(price) {
            return price.toFixed(2);
        }
        add(e) {
            console.log('Add element', e.item);
            this.basket.add(e.item);
        }

    </script>

</catalog>