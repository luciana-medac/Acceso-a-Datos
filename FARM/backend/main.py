from fastapi import FastAPI
from database import get_all_task

app = FastAPI()

@app.get('/')
def welcome():
    return {'message':'Bienvenido a my FastAPI'}

@app.get('/api/tasks')
async def get_tasks():
    tasks = await get_all_task()
    return tasks

@app.get('/api/tasks/{id}')
async def get_task():
    return 'single task'

@app.post('/api/tasks')
async def create_tasks():
    return 'create_tasks'

@app.put('/api/tasks/{id}')
async def update_tasks():
    return 'udating tasks'

@app.delete('/api/tasks/{id}')
async def delete_task():
    return 'delete_task'