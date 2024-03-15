class User:
    def __init__(self, id, name, last_name, age):
        self.id = id
        self.name = name
        self.last_name = last_name
        self.age = age
        self.list_rented_books = []
        self.has_rented_book = False
        self.has_bought_a_book = False

    def get_last_name(self):
        return self.last_name

    def is_has_bought_a_book(self):
        return self.has_bought_a_book

    def set_has_bought_a_book(self, has_bought_a_book):
        self.has_bought_a_book = has_bought_a_book

    def get_id(self):
        return self.id

    def get_name(self):
        return self.name

    def get_age(self):
        return self.age

    def is_has_rented_book(self):
        return self.has_rented_book

    def set_has_rented_book(self, has_rented_book):
        self.has_rented_book = has_rented_book

    def get_list_rented_books(self):
        return self.list_rented_books

    def rent_a_book(self, new_book):
        self.list_rented_books.append(new_book)
