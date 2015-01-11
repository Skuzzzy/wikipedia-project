import os

def getFolders():
	return os.listdir('./extracted-with-links/')

def getPathsFromDirectory(directory):
	fullPaths = []

	localFiles = os.listdir("./extracted-with-links/"+directory)
	for x in localFiles:
		fullPaths.append("./extracted-with-links/"+directory+"/"+x)
	return fullPaths 

fullFileNames = []

allDirectories = getFolders()
for directory in allDirectories:
	fullFileNames = fullFileNames+getPathsFromDirectory(directory)
for fileName in fullFileNames:
	print fileName 

