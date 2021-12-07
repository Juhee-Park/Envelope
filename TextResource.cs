using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using TMPro;

public class TextResource : MonoBehaviour
{
    [SerializeField]
    TextMeshPro resourceText;
    private string resource = " ";
    
    // Start is called before the first frame update
    void Start()
    {
        resourceText = GetComponent<TextMeshPro>();
    }

    // Update is called once per frame
    void Update()
    {
        resourceText.text = resource;
    }

    //get / set 메소드 _ 추후 clickEvent에서 텍스트 접근용. 
    public void SetResource(string name) {
        resource = name;
    }

    public string GetResource() {
        return resource;
    }

}


 
