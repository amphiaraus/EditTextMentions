EditTextMentions
================

EditText subclass with mentions detection ( like Facebook or Twitter )

### How to use it
1) Firstly import the project library into your workspace 
2) **EditTextMentions** is subclass of EditText so in any class you want to detect mentions, set the class EditTextMentions
3) To detect when a mention has started or finished you've to set the MentionsLinstener to your EditText object. You can use the setter:

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

