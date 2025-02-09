class Product:
    def __init__(self, name, price, stock):
        self.name = name
        self.price = price
        self.stock = stock

    def display_info(self):
        return f"{self.name} - ${self.price}"


class Electronics(Product):
    def __init__(self, name, price, stock, warranty):
        super().__init__(name, price, stock)
        self.warranty = warranty

    def display_info(self):
        return f"{self.name} (Warranty: {self.warranty} years) - ${self.price}"


class Clothing(Product):
    def __init__(self, name, price, stock, size):
        super().__init__(name, price, stock)
        self.size = size

    def display_info(self):
        return f"{self.name} (Size: {self.size}) - ${self.price}"


class Food(Product):
    def __init__(self, name, price, stock, expiry_date):
        super().__init__(name, price, stock)
        self.expiry_date = expiry_date

    def display_info(self):
        return f"{self.name} (Expiry: {self.expiry_date}) - ${self.price}"
