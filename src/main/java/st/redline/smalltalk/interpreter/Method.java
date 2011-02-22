/*
Redline Smalltalk is licensed under the MIT License

Redline Smalltalk Copyright (c) 2010 James C. Ladd

Permission is hereby granted, free of charge, to any person obtaining a copy of this software
and associated documentation files (the "Software"), to deal in the Software without restriction,
including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial
portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT
LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE 
SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/
package st.redline.smalltalk.interpreter;

public class Method extends BasicListNode {

	private final Temporaries temporaries;
	private final Pragmas pragmas;
	private final Sequence sequence;

	public Method(MethodPattern methodPattern, Temporaries temporaries, Pragmas pragmas, Sequence sequence) {
		this.temporaries = temporaries;
		this.pragmas = pragmas;
		this.sequence = sequence;
		add(methodPattern);
	}

	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}

	public MethodPattern methodPattern() {
		return (MethodPattern) first();
	}

	public Pragmas pragmas() {
		return pragmas;
	}

	public Temporaries temporaries() {
		return temporaries;
	}

	public Sequence sequence() {
		return sequence;
	}
}
