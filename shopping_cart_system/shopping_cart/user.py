from shopping_cart_system.shopping_cart.shopping_cart import ShoppingCart

class User:
    def __init__(self, username):
        self.username = username
        self.shopping_cart = ShoppingCart()


