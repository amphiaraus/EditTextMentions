EditTextMentions
================

EditText subclass with mentions detection ( like Facebook or Twitter )

### How to use it
1. Firstly import the project library into your workspace 
2. **EditTextMentions** is subclass of EditText so in any class you want to detect mentions, set the class EditTextMentions
3. To detect when a mention has started or finished you've to set the MentionsLinstener to your EditText object. You can use the setter:

```java
	public void setMentionListener(OnMentionListener mentionListener)
```
And then implement the Listener calls:

```java
public interface OnMentionListener extends TextWatcher{
		public void OnMentionStarted(String sequence);
		public void OnMentionFinished();
	}
```
_Notice that the OnMentionStarted call pass an String as input parameter. That string is the sequence written by the user in the mention and will allow you for example to find users__

#### What to do when the user's been selected?
When you'd implemented the user selector and then detected when the user press over an user ( for example from a ListView ) you've to overwrite currently writen mention in the MentionEditText. To do that you've a method:

```java
	public void setSelectedMention(String mention){
```

That overwrite the current mention text with the one selected by the user

## Open Source
Feel free to contribute with this work. I've made a simple implementation but could be improved adding new modules and interesting features. I love OPENSOURCE!
** Contributors **
- Pedro Piñera : @pepibumur

## License - GNU GPLv3
![image](http://www.gnu.org/graphics/gplv3-127x51.png)

This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>

