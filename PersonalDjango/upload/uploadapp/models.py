from django.db import models

# Create your models here.
class Folder(models.Model):
    packageName = models.CharField(max_length=100)
    
    class Meta:  
        db_table = "folder" 