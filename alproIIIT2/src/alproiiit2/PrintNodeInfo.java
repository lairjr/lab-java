/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alproiiit2;

/**
 *
 * @author lairjr
 */
public class PrintNodeInfo {
    private Integer _key;
    private Integer _leftDashNumber;
    private Integer _rightDashNumber;
    private Integer _padLeft;
    
    public PrintNodeInfo(Integer key,
                         Integer leftDashNumber,
                         Integer rightDashNumber) {
        _key = key;
        _leftDashNumber = leftDashNumber;
        _rightDashNumber = rightDashNumber;
        _padLeft = 0;
    }
    
    public PrintNodeInfo(Integer key,
                         Integer leftDashNumber,
                         Integer rightDashNumber,
                         Integer padLeft) {
        _key = key;
        _leftDashNumber = leftDashNumber;
        _rightDashNumber = rightDashNumber;
        _padLeft = padLeft;
    }

    /**
     * @return the _leftDashNumber
     */
    public Integer getLeftDashNumber() {
        return _leftDashNumber;
    }

    /**
     * @param _leftDashNumber the _leftDashNumber to set
     */
    public void setLeftDashNumber(Integer _leftDashNumber) {
        this._leftDashNumber = _leftDashNumber;
    }

    /**
     * @return the _rightDashNumber
     */
    public Integer getRightDashNumber() {
        return _rightDashNumber;
    }

    /**
     * @param _rightDashNumber the _rightDashNumber to set
     */
    public void setRightDashNumber(Integer _rightDashNumber) {
        this._rightDashNumber = _rightDashNumber;
    }

    /**
     * @return the _key
     */
    public Integer getKey() {
        return _key;
    }

    /**
     * @param _key the _key to set
     */
    public void setKey(Integer _key) {
        this._key = _key;
    }

    /**
     * @return the _padLeft
     */
    public Integer getPadLeft() {
        return _padLeft;
    }

    /**
     * @param _padLeft the _padLeft to set
     */
    public void setPadLeft(Integer _padLeft) {
        this._padLeft = _padLeft;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        
        builder.append(repeatChar(" ", _padLeft));
        if (_leftDashNumber > 0) {
            builder.append("|");
            if (_leftDashNumber > 1)
                builder.append(repeatChar("-", _leftDashNumber - 1));
        }
        builder.append(_key.toString());
        if (_rightDashNumber > 0) {
            if (_rightDashNumber > 1)
                builder.append(repeatChar("-", _rightDashNumber - 1));
            builder.append("|");
        }
        
        return builder.toString();
    }
    
    private String repeatChar(String str, int times) {
        return new String(new char[times]).replace("\0", str);
    }
}
