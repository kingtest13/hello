
1 /**
2 * An array list to store strings.
3 *
4 * @author Marcus
5 */
6 public class ArrayStringList implements Stringlist {
7
8	/**
9 * The items in the list.
10 */
11 private String[] items= new String[0];
12
13	/**
14 * Creates a new empty list.
15 */
16 public ArrayStringlist() {
17 super();
18	}
19
20 @Override
21 public void appendString(String text) {
22 String[] newltems = new String[items.length + 1];
23 for (inti= 0; i < items.length; i++) {
24 newltems[i] = items[i];
25	}
26 items= newltems;
27 items[items.length-1] text;
28	}
29
30 @Override
31 public String getStringAt(int i) {
32 return items[i];
33	}
34
35 @Override
36 public void insertStringAt(int i, String text) {
37 String[] newltems = new String[items.length + 1];
38 for (int j = 0; j < i; j++) {
39 newltems[j] items[j];
40	}
41 for (int j = i; j < items.length; j++) {
42 newltems[j+l] = items[j];
43	}
44 items= newltems;
45 items[i] = text;
46	}
47
48 @Override
49 public void insertStringListAt(int i, Stringlist list) {
50 for (int j = list.countElements() - 1; j >= 0; j--) {
51 insertStringAt(i, list.getStringAt(j));
52	}
53	}
54
55 @Override
56 public String replaceStringAt(int i, String text) {
57 String replaced= items[i];
58 items[i] = text;
59 return replaced;
60	}


61

62
@Override
63
public String removeStringAt(int i) {
64
ArrayStringList newlist = new ArrayStringList();
65
String removed= items[i];
66
items[i] = null;
67
for (int j = 0; j < countElements(); j++) {
68
if(getStringAt(j) != null) {
69
newList.appendString(getStringAt(j));
70
}
71
}
72
items= newlist.items;
73
return removed;
74
}
75

76
@Override
77
public String getFirstString() {
78
if(items.length == 0) return null;
79
return items[0];
80
}
81

82
@Override
83
public String getlastString() {
84
if(items.length == 0) return null;
85
return items[items.length - 1];
86
}
87

88
@Override
89
public Stringlist reverseStringList() {
90
ArrayStringList reversed= new ArrayStringList();
91
for(int i = items.length-1; i >= 0; i--) {
92
reversed.appendString(getStringAt(i));
93
}
94
return reversed;
95
}
96

97
@Override
98
public int getindexOfString(String text, int from) {
99
for (inti= from; i < items.length; i++) {
100
if(items[i].equals(text)) {
101
return i;
102
}
103
}
104
return -1;
105
}
106

107
@Override

108
public int
countElements() {
109
return
items.length;
110
}

111


112

@Override
113

public String[] toStringArray() {
114

return items;
115

}
116
}

117


118
/**

119 * A linked list to store strings.
120 *


121
* @author Marcus

122
*/

123
public class LinkedStringlist implements Stringlist
{
124


125
/**

126
* An item in the linked list.

127
*

128
* @author Marcus

129
*/

130
public static class Item {

131


132
/**

133
* The string stored in the item.

134
*/

135
private final String string;

136


137
/**

138
* The next element in the list or

139
* null, if this is the last element.

140
*/

141
private Item next;

142


143
!**

144
* Creates an item to store the string.

145
*

146
* @param string The string to store.

147
*/

148
public Item(String string) {

149
this.string= string;

150
}

151


152
/**

153
* Returns the string stored in the item.

154
*

155
* @return The string stored in the item.

156
*/

157
public String getString() {

158
return string;

159
}

160


161
/**

162
* Returns the next item in the list or

163
* null, if this is the last item.

164
*

165
* @return The next item.

166
*/

167
public Item getNext() {

168
return next;

169
}

170


171
/**

172
* Sets the next item of the list.

173
*

174
* @param next The value for the next item.

175
*/

176
public void setNext(Item next) {

177
this.next= next;

178
}

179


180
}


181


182
I**

183
* The head (i.e. first
element) of the
184
* list or null, if the
list is empty.
185
*I



private Item head;

I**
* Creates a new, empty list.
*I
public LinkedStringList() {
super();
}

@Override
public String getFirstString() {
II check if empty
if (head== null) return null;
II else return string in first element
return head.getString();
}

@Override
public void appendString(String text) { Item newitem = new Item(text);
if (head== null) {
head= newitem;
} else {
Item pointer= head;
while (pointer.getNext() != null) {
pointer= pointer.getNext();
}
pointer.setNext(newitem);
}
}


@Override
public String getStringAt(int i) { Item pointer= head;
while (pointer != null) {
if (i == 0) return pointer.getString(); pointer= pointer.getNext();
i--;
}
return null;
}


@Override
public void insertStringAt(int i, String text) { Item newitem = new Item(text);
if (i	== 0) {
newitem.setNext(head); head= newltem;
} else {
Item pointer= head; Item prev = null;
while (pointer != null && i > 0) {
prev = pointer;


241



pointer	pointer.getNext();
242



i--;
243


}

244


if
(i == 0) {
245



prev.setNext(newitem);
246



newitem.setNext(pointer);
247


}

248

}


249
}



250




251




252 @Override
253 public void insertStringlistAt(int i, Stringlist list) {
254 for(int n = list.countElements()-1; n >= 0; n--) {
255 insertStringAt(i, list.getStringAt(n));
256	}
257	}
258
259 @Override
260 public String replaceStringAt(int i, String text) {
261 Item newitem = new Item(text);
262 Item pointer= head;
263 Item prev = null;
264
265	if	(i	== 0) {
266 newitem.setNext(head.getNext());
267 head= newitem;
268 return pointer.getString();
269 } else {
270 while (pointer != null) {
271	if	(i	== 0) {
272	prev.setNext(newitem);
273	newitem.setNext(pointer.getNext());
274	return pointer.getString();
275	}
276 prev = pointer;
277 pointer= pointer.getNext();
278 i--;
279	}
280	}
281	return null;
282	}
283
284
285 @Override
286 public String removeStringAt(int i) {
287 Item pointer= head;
288 Item prev = null;
289 if(i == 0) {
290 head= head.getNext();
291 return pointer.getString();
292 }else {
293 while(pointer != null) {
294	if(i  == 0) {
295	prev.setNext(pointer.getNext());
296	return pointer.getString();
297	}
298 prev = pointer;
299 pointer= pointer.getNext();
300 i--;

301	}
302	}
303	return null;
304	}
305
306 @Override
307 public String getLastString() {
308 if(head == null) return null;
309 Item pointer= head;
310 while(pointer.getNext() != null) {
311 pointer= pointer.getNext();
312	}
313	return pointer.getString();
314	}
315
316 @Override
317 public Stringlist reverseStringlist() {
318 LinkedStringList reversed= new LinkedStringList();
319 for(int i = 0; i < countElements() ; i++) {
320 reversed.insertStringAt(0, getStringAt(i));
321	}
322	return reversed;
323	}
324
325 @Override
326 public int getindexOfString(String text, int from) { 327
328 Item pointer= head;
329 inti= 0;
330
331 while(pointer != null) {
332 if(i >= from) {
333 if(pointer.getString().equals(text)) {
334 return i;
335	}
336	}
337 pointer	pointer.getNext();
338 i++;
339	}
340	return -1;
341
342	}
343
344 @Override
345 public int countElements() {
346 Item pointer= head;
347 inti= 0;
348 while(pointer != null) {
349 i++;
350 pointer	pointer.getNext();
351	}
352	return i;
353	}
354
355 @Override
356 public String[] toStringArray() {
357 String[] array= new String[countElements()];
358 Item pointer= head;
359 inti= 0;
360 while(pointer != null) {

361 array[i++] = pointer.getString();
362 pointer= pointer.getNext();
363	}



}

}

/**

return array;

370 * An array-based stack that adapts its capacity
371 * by a configurable number of elements.
372 *
373 * @author Marcus
374 */
375 public class StringStack { 376



/**
* The array that stores the item.
*/
private String[] items;

/**
* The current number of items.
*/
private int size= 0;

/**
* The increment by which the items array will
* be increased when there is no more space left.
*/
private int increment	0;

/**
* Creates a new string stack that increments
* its capacity by 10.
*/
public StringStack() { this(10);
}

/**
* Creates a new string stack that increments
* its capacity by the specified increment.
* 
* @param increment The increment, must be> 0.
*/
public StringStack(int increment) { this.increment= increment; this.items= new String[increment];
}

/**
* Pushes the item onto the stack. If the
* stack's capacity is not large enough to
* hold the additional item, the stack's
* capacity will be increased by the stack's
* increment.
* 
* @param item The item to push onto the stack.
*/

421	public void push(String item) {
422	if(getSize() == getCapacity()) {
423	incrementArray();

424
425
426
427
428
429




}

/**

}
items[getSize()] = item; size++;


*/
public String pop() {
String poped = items[getSize()-1]; items[getSize()-1] = null;
size--;
if(getCapacity() - getSize() >= increment*2) { reduceArray();
}
return poped;
}

/**
* Returns the size of the stack.
* 
* @return The size of the stack.
*/
public int getSize() {
return size;
}

/**
* Returns the current capacity of the stack.
* 
* @return The capacity of the stack.
*/
public int getCapacity() {
return items.length;
}

/1------------------------Hilfsmethoden-----------------------

public void incrementArray() {
String[] newArray = new String[getCapacity() + increment];
for (inti= 0; i < getSize(); i++) { newArray[i] = items[i];
}
items= newArray;
}

public void reduceArray() {
String[] newArray = new String[getCapacity() - increment];
for (inti= 0; i < getSize(); i++) { newArray[i] = items[i];


481


}

482


items
newArray;
483

}


484
}


494 public class BinaryintTree {

*/
public Node(int value) { this.value= value;
}



public int toArray(int[] array, int startlndex) {
if (leftChild != null) {
startlndex = leftChild.toArray(array, startlndex);
}
array[startlndex++] = value;
if (rightChild != null) {
startlndex = rightChild.toArray(array, startlndex);
}
return startlndex;
}

558	* The root node.
559	*/
560	private Node root; 561
562	/**
563 * Creates a new binary tree
564 * without any nodes.
565 */
566 public BinaryintTree() {
567 super();
568	}
569
570	/**
571 * Determines whether a value is contained in the tree.
572 *
573 * @param value The value to search for.
574 * @return True if it is contained, false otherwise.
575 */
576 public boolean containsValue(int value) {
577 if(root == null) return false;
578
return containsValue(root, value);
579
}
580

581
private boolean containsValue(Node node, int value) {
582
if(node == null) return false;
583
if(node.value == value) return true;
584
         return value< node.value? containsValue(node.leftChild, value) containsValue(node.rightChild, value);
585
}
586

587
/**
588
* Inserts a value into the tree, if it does not
589
* exist already.
590
*
591
* @param value The value to insert.
592
* @return True if the tree has been modified, false
593
*	otherwise.
594
*I
595
public boolean insertValue(int value) {
596
if(root == null) {
597
root= new Node(value);
598
return true;
599
}
600	return insertValue(root, value);
601	}


private boolean insertValue(Node node, int value) {
if (value< node.value) {
if (node.leftChild == null) { node.leftChild = new Node(value); return true;
} else {
return insertValue(node.leftChild, value);
}
} else if (value> node.value) {
if (node.rightChild == null) {
node.rightChild = new Node(value);
return true;
} else {
return insertValue(node.rightChild, value);
}
} else {
return false;
}
}


/**
* Computes the number of nodes in the tree.
*
* @return The number of nodes in the tree.
*/
public int getNodeCount() { if(root == null) return 0; return getNodeCount(root);
}

private int getNodeCount(Node node) { if(node == null) return 0;
return 1 + getNodeCount(node.leftChild) + getNodeCount(node.rightChild);
}

/**
* Determines whether all nodes have either 0 or 2
* children.
* 
* @return True if all nodes have zero or two children.
*/
public boolean isFull() {
if(root == null) return true; return isFull(root);
}

private boolean isFull(Node node) { if(node == null) return true;
if((node.leftChild == null && node.rightChild == null) I I (node.leftChild != null
&& node.rightChild != null)) {
return isFull(node.leftChild) && isFull(node.rightChild);
}
return false;
}
/**
* Determines whether the tree is perfect. That is


659
* all intermediate nodes have 2 children and all leafs
660
* are on the same level.
661
*
662
* @return True if the tree is perfect.
663
*/

696 }

public boolean isPerfect() {
if(!isFull(root)) return false;
return isSameLevel(root) && isFull(root.leftChild) && isFull(root.rightChild);
}

private boolean isSameLevel(Node node) {
return getHeight(node.leftChild) == getHeight(node.rightChild);

}

private int getHeight(Node node) { if(node == null) return 0;
int heightleft = getHeight(node.leftChild);
int heightRight = getHeight(node.rightChild);
return Math.max(heightleft, heightRight) + 1;
}

/**
* Converts the tree to an int-array that is
* ordered (c.f. in-fix traversal).
*
* @return The ordered int array.
*/
public int[] tointArray() {
int[] result= new int[getNodeCount()];
if (result.length != 0) { root.toArray(result, 0);
}
return result;
}








