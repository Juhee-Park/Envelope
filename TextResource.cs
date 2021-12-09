using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class TextResource : MonoBehaviour
{
    private RaycastHit hit;

    GameObject talkPanel;
    Text talk;

    private string resource = " ";
    
    // Start is called before the first frame update
    void Start()
    {
        talkPanel = GameObject.Find("TalkPanel");
        talk = GameObject.Find("Text").GetComponent<Text>();

        talkPanel.SetActive(false);
    }

    // Update is called once per frame
    void Update()
    {
        talk.text = resource;


    }

    public void SetResource(string name) {
        resource = name;
    }

    public string GetResource() {
        return resource;
    }

    public void SetPanelActive(bool flag) {
        talkPanel.SetActive(flag);
    } 

}


 
