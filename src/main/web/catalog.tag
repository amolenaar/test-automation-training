<catalog>

    <h1>Our catalog</h1>
    <ul>
        <li class="product" each="{ items }">
            <p class="product-name">{ name }</p>
            <p class="product-name">&euro; { renderPrice(price) }</p>
            <a class="product-add-to-basket button" href="#" onclick={ add }>Add to basket</a>

            <svg if="{ inbasket(name) }" version="1.1" xmlns="http://www.w3.org/2000/svg" width="20px" height="20px" viewBox="-229 431 100 100" style="vertical-align: middle">
                <g>
                    <path fill="#079948" d="M-179,432c-26.9,0-49,22-49,49s22.1,49,49,49s49-22,49-49S-152.1,432-179,432z M-188.8,505.5l-24.5-24.5
                l6.9-6.9l17.6,17.6l37.2-37.2l6.9,6.9L-188.8,505.5z"/>
                </g>
            </svg>

        </li>
    </ul>

    <!-- this script tag is optional -->
    <script>
        this.items = opts.items;
        this.basket = opts.basket;

        this.basket.on('updated', this.update);

        renderPrice(price) {
            return price.toFixed(2);
        }
        add(e) {
            console.log('Add element', e.item);
            this.basket.add(e.item);
        }
        inbasket(name) {
            console.log('in basket?', name, this.basket.contains(name));
            return this.basket.contains(name);
        }
    </script>

</catalog>