<basket>
    <h1>Your basket</h1>

    <ul>
        <li class="basket-entry" each={ basket.entries }>
            <p><span class="basket-name">{ product.name }</span>
                <span class="basket-price">&euro; { renderPrice(product.price) }</span>
                <span class="basket-quantity">{quantity}</span>
                <a class="basket-remove" href="#" onclick={ remove }>Remove from basket</a></p>
        </li>
    </ul>

    <button disabled={ basket.entries.length == 0 } onclick={ checkout }>Checkout</button>

    <script>
        this.basket = opts.basket;

        this.basket.on('updated', this.update);

        renderPrice(price) {
            return price.toFixed(2);
        }

        remove(e) {
            this.basket.remove(e.item.product);
        }

        checkout() {
            console.log("Checkout!");
            this.basket.checkout();
        }
    </script>
</basket>