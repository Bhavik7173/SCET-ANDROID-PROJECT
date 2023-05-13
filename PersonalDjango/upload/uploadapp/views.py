from django.shortcuts import render

# Create your views here.
from .models import *
import json,os
from django.views.decorators.csrf import csrf_exempt
from django.http import JsonResponse

# Create your tests here.
@csrf_exempt
def detector(request):
    data = {"success": False}
    print('from detector',data)
    f = []
    flist = Folder.objects.all().values()
    for i in flist:
        print (i,end="\n")
        f.append(i)
    # print("FLIST ===> ",f)

    if request.method == "POST":
        foldername = str(request.POST['folderPath'])
        # print("Path ===> ",foldername)
        # print(type(foldername))

        for list in range (len(f)):
            d = f[list]
            print("D ==> ",type(d["packageName"]))
            if(str(d["packageName"]) == str(foldername)):
                print("Match It...")
                break

    #     static_path = 'uploadapp/static/' + foldername + '/'
    #     if request.FILES.get("file", None) is not None:
    #         img = request.FILES["file"]
    #         path = img.name
    #         fullPath = foldername+path
    #         print("FolderPath==========>",fullPath);
    #         if not os.path.exists('uploadapp/static/' + foldername):
    #             os.mkdir('uploadapp/static/' + str(foldername))
    #         with open('uploadapp/static/'+ path, 'wb+') as destination:  
    #             for chunk in img.chunks():  
    #                 destination.write(chunk)  
    #         image_path = 'app/static/'+ path
            
    #         data = {"success": True}
    #         print(data)
    #         return JsonResponse(data)
    #print(data)
    
    return JsonResponse(data)

@csrf_exempt
def create(request):
    data = {"success": False}
    f = Folder()
    if request.method == "GET":
        path = request.GET['folder']
        isExist = os.path.exists('uploadapp/static/'+path)
        if not isExist:

            os.makedirs('uploadapp/static/'+path)
            print("The new directory is created!")
        data = {"success": True}
        f.packageName = path
        f.save()
        print(data)
        return JsonResponse(data)
    #print(data)
    
    return JsonResponse(data)

def fetchFolder(request):
    flist = list(Folder.objects.all().values())
    print("flist ===> ",flist)
    return JsonResponse(flist,safe=False)
