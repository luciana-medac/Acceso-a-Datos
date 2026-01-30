from motor.motor_asyncio import AsyncIOMotorClient
from model import Task

client = AsyncIOMotorClient('mongodb://lucianaLector:medac@localhost:27017')
database = client.taskdatabase
collection = database.tasks

# Definimos las funciones

# Encuentra una tarea dado un id
async def get_one_task_id(id):
    task = await collection.find_one({'_id':id})
    return task

# Crear una tarea
async def create_task(task):
    # Inserto la tarea
    new_task = await collection.insert_one(task)
    # Recupero la tarea creada (busco la tarea que se ha insertado)
    create_task = await collection.find_one({'_id': new_task.inserted_id})
    return new_task

# Sacar todas las tareas
async def get_all_task():
    # Creo un array de tareas
    tasks = []
    # Defino un cursor que utilice el método find -> sirve para recorrer la consulta (que devuelve más de un registro)
    cursor = collection.find({})
    # Por cada documento del cursor: 
    async for document in cursor:
        tasks.append(Task(**document)) # ** le da el formato para que sea legible
    return tasks


