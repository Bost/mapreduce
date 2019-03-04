#!/usr/bin/env python3

# http://book.pythontips.com/en/latest/map_filter.html

# 1. emacs: add
#    '(python-shell-interpreter "python3.7")
# to custom-set-variables

# 2. sudo apt install --yes python-setuptools
# 3. sudo pip3 install first

from first import first
import json

file = "nyc-yellow-taxi-2017.head-2.json"

def getlines():
    lines = []
    with open(file) as f:
        for line in f:
            lines.append(line)
            # Do something with 'line'
            # print(line)
    return lines

## verify the boiler plate code {{{
## the content
getlines()
thelines = getlines()
## the type
first(thelines)
type(first(thelines))
## }}}

## content processing {{{
## the first conversion - getting the content
map(json.loads, thelines)
jsonelems = list(map(json.loads, thelines))
## verify the conversion {{{
## the type
type(first(jsonelems))
first(jsonelems).keys()
first(jsonelems).get("total_amount") # first(jsonelems)["total_amount"]
## }}}
## }}}


## content processing generalisation {{{
## from single value to a collection of values
list(map(type, jsonelems))
## analyse the type
list(map(lambda elem: elem.keys(), jsonelems))

## it's a dictionary (i.e.hash-map)! Yay :) Let's access it:
def totalamount(dct):
    return dct.get("total_amount")


list(map(totalamount, jsonelems))
## }}}

## getting biiiig {{{
file = "nyc-yellow-taxi-2017.json"
cntlines = len(getlines()) ## >>> 4.000.000 lines
## }}}


## getting low :) {{{
## Let's introduce some scaling / sampling / etc.
## e.g:
def partitionallObj(n, l):
    """Yield successive n-sized chunks from l."""
    for i in range(0, len(l), n):
        yield l[i:i + n]

def partitionall(n, l):
    return list(partitionallObj(n, l))

partitionall(3, [1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
## >>> [[1, 2, 3], [4, 5, 6], [7, 8, 9], [10]]
samplesize = int(cntlines / 8) ## juggling with 8 elems
thelinesamples = partitionall(samplesize, getlines())
len(thelinesamples)
## }}}

from functools import reduce

def reducer(collection):
    """return average"""
    #_(count collection)
    return reduce(lambda x,y: x + y, collection) / len(collection)

## https://gist.github.com/naiquevin/6623428 (Than you Vineet Naik)
def comp(*args):
    first, rest = args[0], args[1:]
    if len(rest) == 0:
        return lambda *a, **k: first(*a, **k)
    elif len(rest) == 1:
        second = rest[0]
        return lambda *a, **k: first(second(*a, **k))
    else:
        return lambda *a, **k: comp(first, comp(*rest))(*a, **k)
##

## e.g.
## comp(lambda x: x + 1, lambda x,y: x ** y)(10) ## >>> 101

def mapper(elem):
    return comp(lambda dct: dct.get("tip_amount"), json.loads)(elem)

def mapreduce(file, mapper, reducer):
    lines = []
    with open(file) as f:
        for line in f:
            lines.append(line)
            # Do something with 'line'
            # print(line)
    # just 20 lines
    return reducer(list(map(mapper, lines[0:20])))

mapreduce("nyc-yellow-taxi-2017.json", mapper, reducer)
## >>> 1.6239999999999999
