function Basket() {
    var self = this;
    riot.observable(this);
    self.entries = [];
    self.add = function(product) {
        for (var index in self.entries) {
            if (self.entries[index].product === product) {
                self.entries[index].quantity += 1;
                self.trigger('updated');
                return;
            }
        }
        self.entries.push({ product: product, quantity: 1 });
        self.trigger('updated');
    };
    self.remove = function(product) {
        for (var index in self.entries) {
            if (self.entries[index].product === product) {
                if (self.entries[index].quantity > 1) {
                    self.entries[index].quantity -= 1;
                } else {
                    self.entries.splice(index, 1);
                }
                self.trigger('updated');
                break;
            }
        }
    };
    self.checkout = function() {
        var total = 0;
        for (var index in self.entries) {
            total += self.entries[index].quantity * self.entries[index].product.price;
        }
        if (total < 25) {
            // Add shipping costs:
            total += 2;
        }
        alert('Total price: ' + total.toFixed(2) + '.');
    };
}
