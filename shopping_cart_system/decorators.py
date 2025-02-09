import logging

def log_cart_update(func):
    def wrapper(self, *args, **kwargs):
        result = func(self, *args, **kwargs)
        logging.info(f"Updated cart: {self.cart}")
        return result
    return wrapper

def limit_quantity(max_quantity):
    def decorator(func):
        def wrapper(self, product, quantity, *args, **kwargs):
            if quantity > max_quantity:
                print(f"Can't add more {max_quantity} goods {product.name}")
                return
            return func(self, product, quantity, *args, **kwargs)
        return wrapper
    return decorator

def validate_numeric_input(func):
    def wrapper(self, *args, **kwargs):
        if isinstance(args[1], str) and not args[1].isdigit():
            print("Error: Quantity must be a number.")
            return
        return func(self, *args, **kwargs)
    return wrapper

