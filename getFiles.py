import os

def getFolders():
	return os.listdir('./extracted-with-links/')

def getPathsFromFile(file):
	fullPaths = []

	localFiles = os.listdir("./extracted-with-links/"+file)
	for x in localFiles:
		fullPaths.append("./extracted-with-links/"+file+"/"+x)
	return fullPaths 

fullFileNames = []

allDirectories = getFolders()
for x in allDirectories:
	fullFileNames = fullFileNames+getPathsFromFile(x)
for x in fullFileNames:
	print x
