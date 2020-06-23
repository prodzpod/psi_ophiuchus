#!/usr/bin/python
import os
THIS_FOLDER = os.path.dirname(os.path.abspath(__file__))

path = os.path.join(THIS_FOLDER, "psimetalPlates_ModBlocks_result.txt")
# change from here
textObject = '''\
    @ObjectHolder(NameBlocks.PSIMETAL_PLATE_BLACK + NameColors.{0}) public static Block psimetalPlateBlack{1};
    @ObjectHolder(NameBlocks.PSIMETAL_PLATE_WHITE + NameColors.{0}) public static Block psimetalPlateWhite{1};
'''
textBlocks = '''\
	register(r_, new BlockPsimetalPlate (properties, DyeColor.{0}.getColorValue()), NameBlocks.PSIMETAL_PLATE_BLACK + NameColors.{1});
	register(r_, new BlockPsimetalPlate (properties, DyeColor.{0}.getColorValue()), NameBlocks.PSIMETAL_PLATE_WHITE + NameColors.{1});
'''
textItemBlocks = '''\
	registerItemBlock(psimetalPlateBlack{0});
	registerItemBlock(psimetalPlateWhite{0});
'''
def writeObject(f, col):
	f.write(textObject.format(col.upper().ljust(10), col.capitalize().ljust(10)))
	return
def writeBlocks(f, col):
	f.write(textBlocks.format(col.upper().ljust(10), col.upper().ljust(10)))
	return
def writeItemBlocks(f, col):
	f.write(textItemBlocks.format(col.capitalize().ljust(10)))
	return

# custom here
dyes = ["white", "light_gray", "gray", "black", "red", "orange", "yellow", "lime", "green", "cyan", "light_blue", "blue", "purple", "magenta", "pink", "brown"]

f = open(path, "w")
for dye in dyes:
	writeObject(f, dye)
for dye in dyes:
	writeBlocks(f, dye)
for dye in dyes:
	writeItemBlocks(f, dye)
f.close()