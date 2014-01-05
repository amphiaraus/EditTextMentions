package com.PPinera.edittextmentions;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.text.TextWatcher;

public class EditTextMentions extends android.widget.EditText implements TextWatcher {
	private boolean selectorShown;
	private OnMentionListener mentionListener;
	private int mentionStart;
	private int mentionEnd;

	public interface OnMentionListener extends TextWatcher{
		public void OnMentionStarted(String sequence);
		public void OnMentionFinished();
	}
	
	public EditTextMentions(Context context) {
		super(context);
		this.selectorShown = false;
		this.mentionStart = 0;
		this.mentionEnd = 0;
		this.addTextChangedListener(this);
	}
	
	public int getCurrentCursorLine()
	{    
	    int selectionStart = Selection.getSelectionStart(this.getText());
	    Layout layout = this.getLayout();

	    if (!(selectionStart == -1)) {
	        return layout.getLineForOffset(selectionStart);
	    }

	    return -1;
	}

	public int getCurrentLineTop(){
		int y = 0;
		int currentLine = getCurrentCursorLine();
		Rect r = new Rect();
		this.getLineBounds(currentLine, r);
		y = r.top-this.getPaddingTop();
		return y;
	}
	
	@Override
	public void afterTextChanged(Editable s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		checkIfMentioning(getMentioningSequence(s, start, count));
	}
	
	private void checkIfMentioning(String mentionSequence){
		if(mentionSequence != null){
	    	if( !selectorShown &&  mentionListener !=null){
	    		mentionListener.OnMentionStarted(mentionSequence);
		    }
	    }
	    if( mentionSequence == null && selectorShown && mentionListener!=null){
    		mentionListener.OnMentionFinished();
		}
	}
	private String getMentioningSequence(CharSequence s, int start, int count){
		
		Pattern pattern = Pattern.compile("(?<=\\s|^)@([a-z|A-Z|\\.|\\-|\\_|0-9]*)(?=\\s|$)");
		Matcher matcher = pattern.matcher(s.toString());
		String mention = null;
	    while (matcher.find()) {
	      if( matcher.start(1) <= start+count && 
	    	  start+count <= matcher.end(1)
	    	  ){
	    	  mentionStart=matcher.start(1);
	    	  mentionEnd=matcher.end(1);
	    	  mention = matcher.group(1);
	    	  break;
	      }
	    }
	    return mention;
	}
	
	public void setMentionListener(OnMentionListener mentionListener) {
		this.mentionListener = mentionListener;
	}
}