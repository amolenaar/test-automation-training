<checkout class="checkout-info" id="checkout">
    <div class="checkout-info-dialog">
        <h2>Checkout <a class="checkout-info-x" href="#">&#x2715;</a></h2>
        <div class="checkout-info-dialog-content">
            <p>Total price: { totalPrice() }.</p>
        </div>
        <p class="checkout-info-dialog-button-bar"><a class="button" href="#">Close</a></p>
    </div>

    <script>
        this.basket = opts.basket;

        this.basket.on('updated', this.update);

        totalPrice() {
            return this.basket.totalPrice().toFixed(2);
        }
    </script>
</checkout>
