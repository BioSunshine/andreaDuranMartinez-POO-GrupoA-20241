
from code_generator import CodeGenerator


class Books:

    def __init__(self, identifier, title, author, year):
        self.id = identifier
        self.title = title
        self.author = author
        self.year = year
        self.its_available = True
    
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
