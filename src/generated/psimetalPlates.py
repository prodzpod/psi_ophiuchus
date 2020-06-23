#!/usr/bin/python
import os
THIS_FOLDER = os.path.dirname(os.path.abspath(__file__))

path = os.path.join(THIS_FOLDER, "resources\\assets\\ophiuchus\\")
# change from here
texture = os.path.join(path, "blockstates\\psimetal_plate_")
model = os.path.join(path, "models\\item\\psimetal_plate_")

text = '''\
{{
  "multipart": [
    {{"apply": {{"model": "psi:block/black_psimetal_plate" }}}},
    {{"apply": {{"model": "ophiuchus:block/psimetal_plate_lines" }}}}
  ]
}}\
'''
textItem = '''\
{{
  "parent": "ophiuchus:item/block",
  "textures": {{
	"layer0": "psi:blocks/psimetal_plate_{}",
	"layer1": "ophiuchus:blocks/psimetal_plate_lines"
  }}
}}\
'''

def writeFile(col):
	f = open(texture + col + "_" + dye + ".json", "w")
	f.write(text.format(col))
	f.close()
	return
def writeFileItem(col):
	f = open(model + col + "_" + dye + ".json", "w")
	f.write(textItem.format(col))
	f.close()

# custom here
dyes = ["white", "light_gray", "gray", "black", "red", "orange", "yellow", "lime", "green", "cyan", "light_blue", "blue", "purple", "magenta", "pink", "brown"]

for dye in dyes:
	writeFile("black")
	writeFileItem("black")
	writeFile("white")
	writeFileItem("white")