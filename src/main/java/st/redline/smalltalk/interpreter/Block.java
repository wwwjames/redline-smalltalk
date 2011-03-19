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

public class Block extends Primary {

	private final Temporaries temporaries;
	private final BlockArgs blockArgs;

	public Block(int line) {
		super(null, line);
		blockArgs = new BlockArgs();
		temporaries = new Temporaries();
	}

	public Block(int line, Sequence sequence) {
		super(sequence, line);
		blockArgs = new BlockArgs();
		temporaries = new Temporaries();
	}

	public Block(int line, Temporaries temporaries, Sequence sequence) {
		super(sequence, line);
		blockArgs = new BlockArgs();
		this.temporaries = temporaries;
	}

	public Block(int line, BlockArgs blockArgs, Sequence sequence) {
		super(sequence, line);
		this.blockArgs = blockArgs;
		temporaries = new Temporaries();
	}

	public Block(int line, BlockArgs blockArgs, Temporaries temporaries, Sequence sequence) {
		super(sequence, line);
		this.blockArgs = blockArgs;
		this.temporaries = temporaries;
	}

	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}

	public boolean hasSequence() {
		return value() != null;
	}

	public Sequence sequence() {
		return (Sequence) value();
	}

	public BlockArgs blockArgs() {
		return blockArgs;
	}

	public Temporaries temporaries() {
		return temporaries;
	}
}
