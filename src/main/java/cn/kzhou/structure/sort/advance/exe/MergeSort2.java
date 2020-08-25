package cn.kzhou.structure.sort.advance.exe;

public class MergeSort2 {

    private int[] array;

    public MergeSort2(int[] array){
        this.array = array;
    }

    public void sort(){
        int[] workSpace = new int [array.length];
        recursiveSort(workSpace,0,array.length-1);
    }

    private void recursiveSort(int[] workspace,int left, int right){
        if(left>=right){
            return ;
        }
        int mid = (left + right)/2;
        recursiveSort(workspace,left,mid);
        recursiveSort(workspace,mid+1,right);
        merge(workspace,left,mid,right);
    }

    private void merge(int[]workspace,int left,int mid, int right){
        int lowBegin = left;
        int lowEnd = mid;
        int highBegin = mid+1;
        int highEnd = right;
        int i = 0;
        int n = right-left+1;
        while (lowBegin<=lowEnd && highBegin<=highEnd){
            if(array[lowBegin]<array[highBegin]){
                workspace[i++] = array[lowBegin++];
            }else {
                workspace[i++] = array[highBegin++];
            }
        }
        while (lowBegin<=lowEnd){
            workspace[i++] = array[lowBegin++];
        }
        while (highBegin<=highEnd){
            workspace[i++] = array[highBegin++];
        }

        for (i=0;i<n;i++){
            array[left++] = workspace[i];
        }
    }

    public int getIndex(int index){
        if(array.length>=index){
            return array[index];
        }
        return -1;
    }
}
