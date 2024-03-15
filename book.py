class Book:
    def __init__(self, id, title, author, year, its_available=True):
        self.id = id
        self.title = title
        self.author = author
        self.year = year
        self.its_available = its_available

    def get_year(self):
        return self.year

    def get_id(self):
        return self.id

    def get_title(self):
        return self.title

    def get_author(self):
        return self.author

    def is_its_available(self):
        return self.its_available

    def set_its_available(self, its_available):
        self.its_available = its_available
