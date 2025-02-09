from shopping_cart_system.decorators import log_cart_update, limit_quantity, validate_numeric_input

class ShoppingCart:
    def __init__(self):
        self.cart = []

    def __iter__(self):
        self._index = 0
        return self

    def __next__(self):
        if self._index < len(self.cart):
            item = self.cart[self._index]
            self._index += 1
            return item
        else:
            raise StopIteration

    @log_cart_update
    @limit_quantity(30)
    @validate_numeric_input
    def add_to_cart(self, product, quantity):
        quantity = int(quantity)
        if product.stock >= quantity:
            self.cart.append((product, quantity))
            product.stock -= quantity
        else:
            print(f"Not enough product for {product.name}")

    @log_cart_update
    def remove_from_cart(self, product_name):
        self.cart = [item for item in self.cart if item[0].name != product_name]

    def calculate_total(self):
        total = sum(item[0].price * item[1] for item in self.cart)
        return total
