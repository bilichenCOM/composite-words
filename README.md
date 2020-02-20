# concatenated words challenge

<p>We have following issue:</p>
<i>given list with approximately 60 000 words<br/>
(combination of letters not divided by a space)<br/>
out of which we should find the longest word<br/>
that is combination of another smaller<br/>
words of the list. It is underlined that possible<br/>
answer should be the word that contains only another<br/>
character sequences from given list and there are not<br/>
any unique sequences of characters.</i>

<p>For example:</p>
<i>if we have following list:</i>

```
cat
catsdogcatsrat
dog
dogcatsdog
hippopotamuses
rat
ratcatdogcat
```
<i>the item ```catsdogcatsrat``` could not be<br/>
considered as potential answer, because<br/>
if we remove all occurrences of ```cat```, ```dog```<br/>
and ```rat``` we get a couple of ```s``` left over.<br/>
In this case the right answer should be<br/>
 ```ratcatdogcat```, which consist of 2 ```cat```<br/>
and words ```rat``` and ```dog```.</i>

