from pydantic import BaseModel

class Task(BaseModel):
    id: str
    title: str
    descripcion: str
    completed: bool = False


