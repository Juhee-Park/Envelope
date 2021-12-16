using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using System.Collections;

public class TextResource : MonoBehaviour
{
    private RaycastHit hit;

    Transform talkPanel;
    Text talk;

    private string resource = " ";
    
    // Start is called before the first frame update
    void Start()
    {
        talkPanel = GameObject.Find("Canvas").transform.Find("TalkPanel");
        talk = GameObject.Find("Text").GetComponent<Text>();

        talkPanel.gameObject.SetActive(false);
    }

    // Update is called once per frame
    void Update()
    {
        talk.text = resource;
        Debug.Log("TR1 : " + GetResource());

    }

    public void SetResource(string name) {
        resource = name;
    }

    public string GetResource() {
        return resource;
    }

    public void SetPanelActive(bool flag) {
        Debug.Log("TR2 : " + GetResource());
        talkPanel.gameObject.SetActive(flag);
    } 

}
