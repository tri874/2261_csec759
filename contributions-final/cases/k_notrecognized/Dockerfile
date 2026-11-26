FROM python:3.12-slim
RUN pip install --no-cache-dir flask==3.1.1
WORKDIR /app
COPY app.py .
EXPOSE 8081
CMD ["python", "app.py"]
